package hu.kristofnagyban.upvotedemo.domain;

import com.sun.istack.NotNull;
import hu.kristofnagyban.upvotedemo.dto.user.UserCreateData;
import hu.kristofnagyban.upvotedemo.security.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class User extends UserCreateData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(Long id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username);
    }
}
