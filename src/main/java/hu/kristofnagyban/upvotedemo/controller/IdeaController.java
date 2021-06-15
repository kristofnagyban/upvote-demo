package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.IdeaBasicInfo;
import hu.kristofnagyban.upvotedemo.dto.IdeaCreateData;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idea")
public class IdeaController extends ExceptionHandlerController {

    private final IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping
    public void sendIdea(@RequestBody IdeaCreateData ideaCreateData) {
        ideaService.saveIdea(ideaCreateData);
    }

    @GetMapping
    public ResponseEntity<List<IdeaBasicInfo>> getApprovedIdeas() {
        return new ResponseEntity<>(ideaService.getApprovedIdeas(), HttpStatus.OK);
    }
}
