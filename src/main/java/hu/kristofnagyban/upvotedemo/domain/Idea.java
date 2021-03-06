package hu.kristofnagyban.upvotedemo.domain;

import com.sun.istack.NotNull;
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
    @Column(columnDefinition = "TEXT")
    @NotNull
    private String description;
    private boolean approved;
    @OneToMany(mappedBy = "idea")
    private List<Vote> votes;

    public Idea() {
    }

    public Idea(Long id, String description, boolean approved, List<Vote> votes) {
        this.id = id;
        this.description = description;
        this.approved = approved;
        this.votes = votes;
    }

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
