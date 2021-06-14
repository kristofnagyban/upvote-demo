package hu.kristofnagyban.upvotedemo.domain;

import hu.kristofnagyban.upvotedemo.security.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Generated
    @Id
    private Long id;
    private String username;
    private String password;
    private Role role;
}
