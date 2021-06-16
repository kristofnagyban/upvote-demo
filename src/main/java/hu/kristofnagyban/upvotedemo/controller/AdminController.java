package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.idea.IdeaAdminInfo;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController extends ExceptionHandlerController {

    private final IdeaService ideaService;

    @Autowired
    public AdminController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @GetMapping("/info")
    public ResponseEntity<List<IdeaAdminInfo>> getIdeasWithCountVotes() {
        return new ResponseEntity<>(ideaService.getIdeasWithStats(), HttpStatus.OK);
    }

    @GetMapping("/approval")
    public ResponseEntity<List<IdeaAdminInfo>> getIdeasForApproval() {
        return new ResponseEntity<>(ideaService.getIdeasForApproval(), HttpStatus.OK);
    }

    @PutMapping("/idea/{id}")
    public ResponseEntity<Void> approveIdea(@PathVariable Long id) {

        if (ideaService.approveIdea(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/idea/{id}")
    public ResponseEntity<Void> discardIdea(@PathVariable Long id) {
        ideaService.deleteIdea(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
