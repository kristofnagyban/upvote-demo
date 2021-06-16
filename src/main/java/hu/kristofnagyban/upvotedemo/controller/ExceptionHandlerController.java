package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.exception.MultipleVotingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Controller
public class ExceptionHandlerController {

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<String> dataExceptionHandler(DataAccessException e) {
        log.error(e.getClass() + " " + e.getMessage());
        return new ResponseEntity<>("You have entered invalid data or a database error has occurred.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MultipleVotingException.class})
    public ResponseEntity<String> multipleVotingHandler(MultipleVotingException e) {
        log.warn(e.getClass() + " " + e.getMessage());
        return new ResponseEntity<>("You tried to vote multiple times in the same session", HttpStatus.FORBIDDEN);
    }
}
