package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.UserRegisterData;
import hu.kristofnagyban.upvotedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationController extends ExceptionHandlerController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void registerUser(@RequestBody UserRegisterData userRegisterData) {
        userService.registerUser(userRegisterData);
    }
}
