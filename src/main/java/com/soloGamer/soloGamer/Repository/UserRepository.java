package com.soloGamer.soloGamer.Repository;

import com.soloGamer.soloGamer.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByEmail(String email);

    User findByResetPasswordToken(String token);

    @Query(value = "SELECT * FROM users WHERE "
            + "MATCH(game, clasament, main)" +
            "AGAINST (?1)",
            nativeQuery = true)
    public List<User> search(String keyword);
}