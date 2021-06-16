package hu.kristofnagyban.upvotedemo.service;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import hu.kristofnagyban.upvotedemo.domain.Vote;
import hu.kristofnagyban.upvotedemo.exception.MultipleVotingException;
import hu.kristofnagyban.upvotedemo.repository.VoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {

    private VoteService voteService;

    @Mock
    private VoteRepository voteRepository;

    @Mock
    private IdeaService ideaService;

    @BeforeEach
    void init() {
        voteService = new VoteService(voteRepository, ideaService);
    }

    @Test
    void test_saveVote_Idea1SessionQwert_success() {
        Idea idea = new Idea(1L, "Good idea", true, Collections.emptyList());

        Mockito.when(ideaService.getById(1L)).thenReturn(new Idea(1L, "Good idea", true, Collections.emptyList()));

        Vote vote = new Vote(idea, "qwert");

        Mockito.when(voteRepository.findAll()).thenReturn(Collections.emptyList());
        Mockito.when(voteRepository.save(vote)).thenReturn(vote);

        assertEquals(new Vote(idea, "qwert"), voteService.saveVote(1L, "qwert"));

        Mockito.verify(ideaService).getById(1L);
        Mockito.verify(voteRepository).findAll();
        Mockito.verify(voteRepository).save(vote);
    }

    @Test
    void test_saveVote_Idea4SessionUiopjk_fail() {
        Idea otherIdea = new Idea(4L, "Very good idea", true, Collections.emptyList());

        Mockito.when(ideaService.getById(4L)).thenReturn(otherIdea);

        Vote vote = new Vote(otherIdea, "uiopjk");

        Mockito.when(voteRepository.findAll()).thenReturn(List.of(vote));

        assertThrows(MultipleVotingException.class, () -> voteService.saveVote(4L, "uiopjk"));

        Mockito.verify(ideaService).getById(4L);
        Mockito.verify(voteRepository).findAll();
        Mockito.verify(voteRepository, times(0)).save(vote);
    }
}