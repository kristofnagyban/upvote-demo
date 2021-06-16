package hu.kristofnagyban.upvotedemo.dto.user;

import lombok.Data;

@Data
public class UserRegisterData {

    private String username;
    private String password;

    public UserRegisterData() {
    }

    public UserRegisterData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
