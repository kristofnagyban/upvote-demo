package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.User;
import hu.kristofnagyban.upvotedemo.dto.UserRegisterData;
import hu.kristofnagyban.upvotedemo.repository.UserRepository;
import hu.kristofnagyban.upvotedemo.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);
    }

    public User registerUser(UserRegisterData userRegisterData) {
        User user = new User();
        user.setUsername(userRegisterData.getUsername());
        user.setPassword(userRegisterData.getPassword());
        user.setRole(Role.BASIC);
        return userRepository.save(user);
    }
}
