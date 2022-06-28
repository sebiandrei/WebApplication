package com.soloGamer.soloGamer.Service;

import com.soloGamer.soloGamer.Details.CustomUserDetails;
import com.soloGamer.soloGamer.Model.User;
import com.soloGamer.soloGamer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
        User user = repo.findByEmail(email);
        if (user != null) {
            user.setResetPasswordToken(token);
            repo.save(user);
        } else {
            throw new UserNotFoundException("Could not find any user with this email" + email);
        }
    }

    public User getByResetPasswordToken(String resetPasswordToken) {
        return repo.findByResetPasswordToken(resetPasswordToken);
    }

    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);

        user.setResetPasswordToken(null);
        repo.save(user);
    }

    public List<User> search(String keyword) {
        return repo.search(keyword);
    }
}
