package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.IdeaBasicInfo;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import hu.kristofnagyban.upvotedemo.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

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
}
