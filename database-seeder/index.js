const mysql = require('promise-mysql');
const faker = require('faker');
let connection;

const NUMBER_OF_STUDENTS = 20000;
const NUMBER_OF_SCHOOLS = 100;
const NUMBER_OF_CLASSES_PER_SCHOOL = 5;
const NUMBER_OF_ACTIVITIES = 500;
const NUMBER_OF_ACTIVITIES_PER_STUDENT = 2;
const NUMBER_OF_TEACHERS = Math.floor(NUMBER_OF_SCHOOLS * NUMBER_OF_CLASSES_PER_SCHOOL / 5);

function connectMysql() {
    return mysql.createConnection({
        host     : 'localhost',
        user     : 'root',
        password : 'our50fugu',
        database : 'tazuzu'
    }).then((conn) => {
        connection = conn;
        return connection;
    }).catch(err => {
        console.log(err);
        process.exit();
    });
}

function seedSchools() {
    const schoolsData = [];
    for(let i=0; i<NUMBER_OF_SCHOOLS; i++) {
        schoolsData.push([
            faker.address.city(),
            faker.company.companyName()
        ]);
    }

    return connection.query('INSERT INTO school(`city`, `name`) VALUES ?', [schoolsData])
        .then((result) => {
            console.log('Inserted schools');
            return result;
        });
}

function seedClasses() {
    const classesData = [];
    for(let i=1; i<NUMBER_OF_SCHOOLS+1; i++) {
        for(let j=1; j<NUMBER_OF_CLASSES_PER_SCHOOL+1; j++) {
            classesData.push([
                String.fromCharCode(97 + j),
                i
            ]);
        }
    }

    return connection.query('INSERT INTO class(`name`, `school_id`) VALUES ?', [classesData])
        .then((result) => {
            console.log('Inserted classes');
            return result;
        });
}

const userNames = new Set();
const emails = new Set();
function getUsername() {
    const currentUsername = faker.internet.userName();
    if ( userNames.has(currentUsername) ) {
        return getUsername();
    }
    userNames.add(currentUsername);
    return currentUsername;
}
function getEmail() {
    const currentEmail = faker.internet.email();
    if ( emails.has(currentEmail) ) {
        return getEmail();
    }
    emails.add(currentEmail);
    return currentEmail;
}

function seedStudents() {
    const studentsData = [];

    function getUsername() {
        const currentUsername = faker.internet.userName();
        if ( userNames.has(currentUsername) ) {
            return getUsername();
        }
        userNames.add(currentUsername);
        return currentUsername
    }

    for(let i=0; i<NUMBER_OF_STUDENTS; i++) {
        studentsData.push([
            'STUDENT',
            getEmail(),
            faker.name.firstName(),
            faker.name.lastName(),
            i % 2 == 0 ? 'M' : 'F', //gender
            1, //is_activated
            faker.internet.password(),
            faker.internet.url(),
            getUsername(),
            9000000 + i,
            Math.floor(Math.random() * 200) + 120,
            Math.floor(Math.random() * 150) + 40,
            Math.floor(Math.random() * NUMBER_OF_SCHOOLS) + 1,
            Math.floor(Math.random() * NUMBER_OF_SCHOOLS * NUMBER_OF_CLASSES_PER_SCHOOL) + 1,
        ]);
    }

    return connection.query(`INSERT INTO user(
                                user_type, email, first_name, last_name, gender, 
                                is_activated, password, photo_path, user_name, gov_id, 
                                height, weight, school_id, school_class_id
                            ) VALUES ?`, [studentsData])
        .then((result) => {
            console.log('Inserted students');
            return result;
        });
}

function seedTeachers() {
    const teachersData = [];

    for(let i=0; i<NUMBER_OF_TEACHERS; i++) {
        teachersData.push([
            'TEACHER',
            getEmail(),
            faker.name.firstName(),
            faker.name.lastName(),
            i % 2 == 0 ? 'M' : 'F', //gender
            1, //is_activated
            faker.internet.password(),
            faker.internet.url(),
            getUsername(),
            9000000 + i,
            Math.floor(Math.random() * 200) + 120,
            Math.floor(Math.random() * 150) + 40,
            Math.floor(Math.random() * NUMBER_OF_SCHOOLS) + 1
        ]);
    }

    return connection.query(`INSERT INTO user(
                                user_type, email, first_name, last_name, gender, 
                                is_activated, password, photo_path, user_name, gov_id, 
                                height, weight, school_id
                            ) VALUES ?`, [teachersData])
        .then((result) => {
            console.log('Inserted teachers');
            return result;
        });
}

function seedActivities() {
    const activitiesData = [];

    for(let i=0; i<NUMBER_OF_ACTIVITIES; i++) {
        activitiesData.push([
            faker.lorem.word(),
            Math.floor(Math.random() * 3) + 0,
            Math.floor(Math.random() * 5) + 1
        ]);
    }

    return connection.query(`INSERT INTO activity(
                                activity_name, activity_type_id, num_of_measurements
                            ) VALUES ?`, [activitiesData])
        .then((result) => {
            console.log('Inserted activities');
            return result;
        });
}

function seedActivitiesStudents() {
    const activitiesData = [];

    for(let i=1; i<=NUMBER_OF_STUDENTS; i++) {
        for(let j=0; j<NUMBER_OF_ACTIVITIES_PER_STUDENT; j++) {
            activitiesData.push([
                i,
                Math.floor(Math.random() * NUMBER_OF_ACTIVITIES) + 1
            ]);
        }
    }

    return connection.query(`INSERT INTO activity_students(
                                activity_id, student_id
                            ) VALUES ?`, [activitiesData])
        .then((result) => {
            console.log('Inserted activities for students');
            return result;
        });
}

connectMysql()
    // .then(seedSchools)
    // .then(seedClasses)
    // .then(seedStudents)
    // .then(seedTeachers)
    // .then(seedActivities)
    .then(seedActivitiesStudents)
    .then((result) => {
        console.log('Done');
        process.exit(1);
    });