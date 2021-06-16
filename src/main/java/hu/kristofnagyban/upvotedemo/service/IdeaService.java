package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import hu.kristofnagyban.upvotedemo.dto.idea.IdeaAdminInfo;
import hu.kristofnagyban.upvotedemo.dto.idea.IdeaBasicInfo;
import hu.kristofnagyban.upvotedemo.dto.idea.IdeaCreateData;
import hu.kristofnagyban.upvotedemo.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class IdeaService {

    private final IdeaRepository ideaRepository;
    private final VoteService voteService;

    @Autowired
    public IdeaService(IdeaRepository ideaRepository, VoteService voteService) {
        this.ideaRepository = ideaRepository;
        this.voteService = voteService;
    }

    public Optional<Idea> saveIdea(IdeaCreateData ideaCreateData) {
        Idea idea = new Idea();
        idea.setDescription(ideaCreateData.getDescription());
        idea.setApproved(false);
        return Optional.of(ideaRepository.save(idea));
    }

    public List<IdeaAdminInfo> getIdeasForApproval() {
        return ideaAdminInfoMapper(ideaRepository.findByApprovedFalse());
    }

    public Optional<Idea> approveIdea(Long id) {
        Idea idea = ideaRepository.getById(id);
        idea.setApproved(true);
        return Optional.of(ideaRepository.save(idea));
    }

    public void deleteIdea(Long id) {
        ideaRepository.deleteById(id);
    }

    public List<IdeaAdminInfo> getIdeasWithStats() {
        return ideaAdminInfoMapper(ideaRepository.findByApprovedTrue());
    }

    public List<IdeaBasicInfo> getIdeasForVoting(String sessionId) {
        List<IdeaBasicInfo> approvedIdeas = getApprovedIdeas();
        List<Long> votedIdeasInSession = voteService.getAllVotes().stream()
                .filter(vote -> vote.getSessionId().equals(sessionId))
                .mapToLong(vote -> vote.getIdea().getId())
                .boxed()
                .collect(Collectors.toList());
        return approvedIdeas.stream()
                .map(idea -> {
                    if (!votedIdeasInSession.contains(idea.getId())) {
                        idea.setVotable(true);
                    }
                    return idea;
                })
                .collect(Collectors.toList());
    }

    public Idea getById(Long id) {
        return ideaRepository.findById(id).orElse(new Idea());
    }

    private List<IdeaBasicInfo> getApprovedIdeas() {
        List<Idea> approvedIdeas = ideaRepository.findAll().stream()
                .filter(Idea::isApproved)
                .collect(Collectors.toList());
        return ideaBasicInfoMapper(approvedIdeas);
    }

    private List<IdeaBasicInfo> ideaBasicInfoMapper(List<Idea> ideas) {
        return ideas.stream()
                .map(idea -> new IdeaBasicInfo(idea.getId(), idea.getDescription()))
                .collect(Collectors.toList());
    }

    private List<IdeaAdminInfo> ideaAdminInfoMapper(List<Idea> ideas) {
        return ideas.stream()
                .map(idea -> {
                    IdeaAdminInfo ideaAdminInfo = new IdeaAdminInfo();
                    ideaAdminInfo.setId(idea.getId());
                    ideaAdminInfo.setDescription(idea.getDescription());
                    ideaAdminInfo.setApproved(idea.isApproved());
                    ideaAdminInfo.setVotes(idea.getVotes().size());
                    return ideaAdminInfo;
                })
                .collect(Collectors.toList());
    }

}
