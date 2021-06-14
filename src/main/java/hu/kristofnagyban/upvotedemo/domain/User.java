package hu.kristofnagyban.upvotedemo.domain;

import hu.kristofnagyban.upvotedemo.dto.UserCreateData;
import hu.kristofnagyban.upvotedemo.security.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User extends UserCreateData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role;

}
