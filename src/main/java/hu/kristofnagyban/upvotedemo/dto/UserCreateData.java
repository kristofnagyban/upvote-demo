package hu.kristofnagyban.upvotedemo.dto;

import hu.kristofnagyban.upvotedemo.security.Role;
import lombok.Data;

@Data
public class UserCreateData extends UserRegisterData {

    private Role role;
}
