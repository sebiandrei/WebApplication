package com.soloGamer.soloGamer;

import static org.assertj.core.api.Assertions.assertThat;

import com.soloGamer.soloGamer.Model.User;
import com.soloGamer.soloGamer.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("testare@gmail.com");
        user.setPassword("testare");
        user.setDiscord("testare#9999");
        user.setGame("Black Desert");
        user.setLevel("60");
        user.setClasament("none");
        user.setMain("Lahm");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "test@gmail.com";

                User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
    }
}
