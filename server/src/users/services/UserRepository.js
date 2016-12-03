const uuid = require('uuid');
const faker = require('faker');

let users = [];

for(let i=0; i<1000; i++) {
    users.push({
        id: uuid(),
        name: faker.name.findName(),
        email: faker.internet.email()
    });
}

const _persistUser = (user = {}) => {
    user.id = uuid();
    users.push(user);
    return true;
};

const _retrieveUsers = () => {
    return users;
};

const _findOneById = (userId) => {
    return users.find((u) => u.id === userId);
};

const _deleteUser = (userId = null) => {
    if ( !userId ) {
        return false;
    }

    newList = users.filter((u) => u.id !== userId);

    if ( newList.length === users.length ) {
        throw new Error('user');
    }

    users = newList;
    return true;
};

module.exports = {
    persistUser: _persistUser,
    deleteUser: _deleteUser,
    retrieveUsers: _retrieveUsers,
    findOneById: _findOneById
};