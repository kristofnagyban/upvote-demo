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
}
