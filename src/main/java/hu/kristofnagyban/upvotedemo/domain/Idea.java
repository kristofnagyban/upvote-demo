package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Idea {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String description;
    private boolean approved;
    @OneToMany(mappedBy = "idea")
    private List<Vote> votes;
}
