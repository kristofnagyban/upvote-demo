package hu.kristofnagyban.upvotedemo.controller;

import hu.kristofnagyban.upvotedemo.dto.IdeaCreateData;
import hu.kristofnagyban.upvotedemo.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/idea")
public class IdeaController {

    private final IdeaService ideaService;

    @Autowired
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping
    public void sendIdea(@RequestBody IdeaCreateData ideaCreateData) {
        ideaService.saveIdea(ideaCreateData);
    }
}
