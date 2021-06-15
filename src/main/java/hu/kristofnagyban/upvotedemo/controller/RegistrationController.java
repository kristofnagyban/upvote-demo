package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.user.UserRegisterData;
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
    public ResponseEntity<Void> registerUser(@RequestBody UserRegisterData userRegisterData) {
        if (userService.registerUser(userRegisterData).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<Boolean> isUsernameAvailable(@RequestParam String username) {
        return new ResponseEntity<>(userService.isUsernameAvailable(username), HttpStatus.OK);
    }
}
