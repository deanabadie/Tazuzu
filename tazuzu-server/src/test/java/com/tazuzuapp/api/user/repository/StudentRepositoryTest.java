package com.tazuzuapp.api.user.repository;

import com.tazuzuapp.api.user.domain.Student;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository repository;

    @Test
    public void findAllTest() throws Exception {
        List<Student> sl = this.repository.findAll();
        assertThat(sl.size() > 0);
        assertThat(sl.size()).isEqualTo(1);
    }

    @Test
    public void deleteUserTest() throws Exception {
        Student s = this.repository.findOne(new Long(1));
        this.repository.delete(s);
        Student dbStudent = repository.findOne(s.getId());
        assertThat(dbStudent).isNull();
    }
}
