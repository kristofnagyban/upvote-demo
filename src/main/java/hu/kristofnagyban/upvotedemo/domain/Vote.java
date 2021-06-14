package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Vote {

    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Idea idea;
    private String sessionId;
}
