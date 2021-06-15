package hu.kristofnagyban.upvotedemo.domain;

import hu.kristofnagyban.upvotedemo.dto.user.UserCreateData;
import hu.kristofnagyban.upvotedemo.security.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User extends UserCreateData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
