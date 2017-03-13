package com.tazuzu.user.repository;

/**
 * Created by deana on 13/03/2017.
 */
import com.tazuzu.user.domain.Student;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void findByUserNameTest() throws Exception {
        Student s = this.repository.findByUserName("jacky");
        assertThat(s.getFirstName()).isEqualTo("Jack");
        assertThat(s.getLastName()).isEqualTo("Sparrow");
    }

}
