package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final IdeaService ideaService;

    @Autowired
    public AdminController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping
    public ResponseEntity<List<Idea>> getIdeasForAdmin() {
        return new ResponseEntity<>(ideaService.getIdeasForAdmin(), HttpStatus.OK);
    }
}
