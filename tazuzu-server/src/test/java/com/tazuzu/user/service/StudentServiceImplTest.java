package com.tazuzu.user.service;

import com.tazuzu.user.domain.Student;
import com.tazuzu.user.repository.StudentRepository;
import org.junit.Test;


/**
 * Created by Noy on 19/01/2017.
 */
public class StudentServiceImplTest extends StudentServiceImpl {
    private StudentRepository studentRepository;
    private StudentServiceImpl studentService;
    /**
     * Auto wired is injecting a service representing the required type
     * Because we declared StudentRepository as a @Repository (which is just another type of @Component)
     * We can inject every service/repository/component into other Spring components by using the autowired annotation
     * You just declare a new constructor with all the types that you want to use and Spring is doing it for you...
     * <p>
     * The initial example you did was declaring Autowired on a property and not on the constructor - which is bad practice
     * Do not do it :)
     *
     * @param studentRepository
     */
    public StudentServiceImplTest(StudentRepository studentRepository) {
        super(studentRepository);
    }
       @Test
        public void getStudent() throws Exception {
           Student newStudent = new Student();
           newStudent.setEmail("noyam@post.bgu.ac.il");
           newStudent.setFirstName("noy");
           newStudent.setLastName("eldar");
           newStudent.setGroupId(new Long(1));
           newStudent.setPhotoPath("photo/photo");
           newStudent.setUserName("noyam");
           newStudent.setActivated(true);
           newStudent.setGovId(new Long(307934190));
           newStudent.setHeight(1.70);
           newStudent.setWeight(60);
           studentRepository.save(newStudent);
           assert (studentService.getStudent(newStudent.getId()).equals(newStudent));
        }

    /*    @Test
        public void getAllStudents() throws Exception {

        }
    */
    @Test
    public void createStudent() throws Exception {
        Student newStudent = new Student();
        newStudent.setEmail("noyam@post.bgu.ac.il");
        newStudent.setFirstName("noy");
        newStudent.setLastName("eldar");
        newStudent.setGroupId(new Long(1));
        newStudent.setPhotoPath("photo/photo");
        newStudent.setUserName("noyam");
        newStudent.setActivated(true);
        newStudent.setGovId(new Long(307934190));
        newStudent.setHeight(1.70);
        newStudent.setWeight(60);

        String s = newStudent.getEmail();
        System.out.print(s);

        studentService.createStudent(newStudent);
        Student existStudent;
        existStudent = studentService.getStudent(newStudent.getId());
        assert(newStudent.equals(existStudent));
    }

    @Test
    public void updateStudent() throws Exception {

    }

    @Test
    public void exists() throws Exception {

    }

    /**
     * Auto wired is injecting a service representing the required type
     * Because we declared StudentRepository as a @Repository (which is just another type of @Component)
     * We can inject every service/repository/component into other Spring components by using the autowired annotation
     * You just declare a new constructor with all the types that you want to use and Spring is doing it for you...
     * <p>
     * The initial example you did was declaring Autowired on a property and not on the constructor - which is bad practice
     * Do not do it :)
     *
     * @param studentRepository
    */


}