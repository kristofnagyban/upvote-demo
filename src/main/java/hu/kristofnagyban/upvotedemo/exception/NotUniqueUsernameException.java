package hu.kristofnagyban.upvotedemo.exception;

public class NotUniqueUsernameException extends RuntimeException {

    public NotUniqueUsernameException(String errorMessage) {
        super(errorMessage);
    }
}
