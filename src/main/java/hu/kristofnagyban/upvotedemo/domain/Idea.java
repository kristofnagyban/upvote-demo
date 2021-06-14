package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Idea {

    @GeneratedValue
    @Id
    private Long id;
    private String description;
    private boolean approved;
    @OneToMany(mappedBy = "idea")
    private List<Vote> votes;
}
