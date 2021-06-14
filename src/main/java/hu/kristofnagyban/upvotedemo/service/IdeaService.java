package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import hu.kristofnagyban.upvotedemo.dto.IdeaCreateData;
import hu.kristofnagyban.upvotedemo.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IdeaService {

    private final IdeaRepository ideaRepository;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    public Idea saveIdea(IdeaCreateData ideaCreateData) {
        Idea idea = new Idea();
        idea.setDescription(ideaCreateData.getDescription());
        System.out.println(idea.getDescription());
        idea.setApproved(false);
        return ideaRepository.save(idea);
    }

    public List<Idea> getIdeasForAdmin() {
        return ideaRepository.findAll();
    }
}
