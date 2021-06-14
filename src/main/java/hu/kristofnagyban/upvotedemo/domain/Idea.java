package hu.kristofnagyban.upvotedemo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idea idea = (Idea) o;
        return id.equals(idea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
