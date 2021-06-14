package hu.kristofnagyban.upvotedemo.security;

public enum Role {
    BASIC("BASIC"),
    ADMIN("ADMIN");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
