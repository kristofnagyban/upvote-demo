package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.idea.IdeaBasicInfo;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import hu.kristofnagyban.upvotedemo.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/vote")
public class VoteController extends ExceptionHandlerController {

    private final VoteService voteService;
    private final IdeaService ideaService;

    @Autowired
    public VoteController(VoteService voteService, IdeaService ideaService) {
        this.voteService = voteService;
        this.ideaService = ideaService;
    }

    @GetMapping
    public ResponseEntity<List<IdeaBasicInfo>> getIdeasForVoting(HttpSession session) {
        return new ResponseEntity<>(ideaService.getIdeasForVoting(session.getId()), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> sendVote(@PathVariable Long id, HttpSession session) {
        voteService.saveVote(id, session.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
