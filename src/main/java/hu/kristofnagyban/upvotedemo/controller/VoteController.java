package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.IdeaBasicInfo;
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
    public ResponseEntity<List<IdeaBasicInfo>> getIdeasForVoting() {
        return new ResponseEntity<>(ideaService.getApprovedIdeas(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public void sendVote(@PathVariable Long id, HttpSession session) {
        voteService.saveVote(id, session.getId());
    }
}
