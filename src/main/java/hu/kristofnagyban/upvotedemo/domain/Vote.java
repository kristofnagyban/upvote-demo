package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Vote {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    private Idea idea;
    private String sessionId;

    public Vote() {
    }

    public Vote(Idea idea, String sessionId) {
        this.idea = idea;
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return idea.equals(vote.idea) && sessionId.equals(vote.sessionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idea, sessionId);
    }
}
