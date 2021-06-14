package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Vote;
import hu.kristofnagyban.upvotedemo.repository.VoteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VoteService {

    private final VoteRepository voteRepository;
    private final IdeaService ideaService;

    public VoteService(VoteRepository voteRepository, IdeaService ideaService) {
        this.voteRepository = voteRepository;
        this.ideaService = ideaService;
    }

    public void saveVote(Long ideaId, String sessionId) {
        Vote vote = new Vote(ideaService.getById(ideaId), sessionId);
        if (!voteRepository.findAll().contains(vote)) {
            voteRepository.save(vote);
        }
    }
}
