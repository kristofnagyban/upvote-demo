package hu.kristofnagyban.upvotedemo.repository;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
}
