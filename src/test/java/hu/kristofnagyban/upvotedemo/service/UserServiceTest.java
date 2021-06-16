package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.User;
import hu.kristofnagyban.upvotedemo.dto.user.UserRegisterData;
import hu.kristofnagyban.upvotedemo.repository.UserRepository;
import hu.kristofnagyban.upvotedemo.security.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach

    void init() {
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    void test_isUsernameAvailable_jack_true() {
        Mockito.when(userRepository.findByUsername("jack")).thenReturn(Optional.empty());
        Assertions.assertTrue(userService.isUsernameAvailable("jack"));
        verify(userRepository).findByUsername("jack");
    }

    @Test
    void test_isUsernameAvailable_john_false() {
        Mockito.when(userRepository.findByUsername("john")).thenReturn(Optional.of(new User(2L, "john", "asdf1234", Role.BASIC)));
        Assertions.assertFalse(userService.isUsernameAvailable("john"));
        verify(userRepository).findByUsername("john");
    }

    @Test
    void test_registerUser_monicaPassword123_success() {
        UserRegisterData userRegisterData = new UserRegisterData("monica", "password123");
        User user = new User();
        user.setUsername(userRegisterData.getUsername());
        user.setPassword("xyz789");
        user.setRole(Role.BASIC);

        Mockito.when(passwordEncoder.encode(userRegisterData.getPassword())).thenReturn("xyz789");
        Mockito.when(userRepository.findByUsername(userRegisterData.getUsername())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(user)).thenReturn(user);

        Assertions.assertEquals(Optional.of(user), userService.registerUser(userRegisterData));

        Mockito.verify(passwordEncoder).encode(userRegisterData.getPassword());
        Mockito.verify(userRepository).findByUsername(userRegisterData.getUsername());
        Mockito.verify(userRepository).save(user);
    }


}