package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Vote;
import hu.kristofnagyban.upvotedemo.exception.MultipleVotingException;
import hu.kristofnagyban.upvotedemo.repository.VoteRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VoteService {

    private final VoteRepository voteRepository;
    private final IdeaService ideaService;

    public VoteService(VoteRepository voteRepository, @Lazy IdeaService ideaService) {
        this.voteRepository = voteRepository;
        this.ideaService = ideaService;
    }

    public Vote saveVote(Long ideaId, String sessionId) {
        Vote vote = new Vote(ideaService.getById(ideaId), sessionId);
        if (!voteRepository.findAll().contains(vote)) {
            return voteRepository.save(vote);
        } else {
            throw new MultipleVotingException("You tried to vote multiple times in the same session.");
        }
    }

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }
}
