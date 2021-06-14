package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import hu.kristofnagyban.upvotedemo.dto.IdeaAdminInfo;
import hu.kristofnagyban.upvotedemo.dto.IdeaCreateData;
import hu.kristofnagyban.upvotedemo.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<IdeaAdminInfo> getIdeasForAdmin() {
        return ideaRepository.findAll().stream()
                .map(idea -> {
                    IdeaAdminInfo ideaAdminInfo = new IdeaAdminInfo();
                    ideaAdminInfo.setId(idea.getId());
                    ideaAdminInfo.setDescription(idea.getDescription());
                    ideaAdminInfo.setVotes(idea.getVotes().size());
                    return ideaAdminInfo;
                })
                .collect(Collectors.toList());
    }

    public void deleteIdea(Long id) {
        ideaRepository.deleteById(id);
    }
}
