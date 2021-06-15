package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.UserRegisterData;
import hu.kristofnagyban.upvotedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Boolean> isUsernameAvailable(@RequestParam String username) {
        return new ResponseEntity<>(userService.isUsernameAvailable(username), HttpStatus.OK);
    }
}
