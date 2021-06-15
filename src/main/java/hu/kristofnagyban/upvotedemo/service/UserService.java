package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.User;
import hu.kristofnagyban.upvotedemo.dto.user.UserRegisterData;
import hu.kristofnagyban.upvotedemo.repository.UserRepository;
import hu.kristofnagyban.upvotedemo.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
    }

    public boolean isUsernameAvailable(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    public User registerUser(UserRegisterData userRegisterData) {
        User user = new User();
        user.setUsername(userRegisterData.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterData.getPassword()));
        user.setRole(Role.BASIC);
        return userRepository.save(user);
    }
}
