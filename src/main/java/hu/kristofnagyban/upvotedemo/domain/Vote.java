package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;

import javax.persistence.*;

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
}
