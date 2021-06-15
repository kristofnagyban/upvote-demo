package hu.kristofnagyban.upvotedemo.exception;

public class MultipleVotingException extends RuntimeException {

    public MultipleVotingException(String errorMessage) {
        super(errorMessage);
    }
}
