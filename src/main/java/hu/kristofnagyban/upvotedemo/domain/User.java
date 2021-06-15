package hu.kristofnagyban.upvotedemo.domain;

import com.sun.istack.NotNull;
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
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

}
