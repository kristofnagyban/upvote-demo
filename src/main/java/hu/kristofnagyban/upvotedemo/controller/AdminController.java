package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.IdeaAdminInfo;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<IdeaAdminInfo>> getIdeasForAdmin() {
        return new ResponseEntity<>(ideaService.getIdeasForAdmin(), HttpStatus.OK);
    }

    @PutMapping("/idea/{id}")
    public void approveIdea(@PathVariable Long id) {

    }

    @DeleteMapping("/idea/{id}")
    public void discardIdea(@PathVariable Long id) {
        ideaService.deleteIdea(id);
    }
}
