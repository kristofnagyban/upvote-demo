package hu.kristofnagyban.upvotedemo.repository;

import hu.kristofnagyban.upvotedemo.domain.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {

    List<Idea> findByApprovedTrue();

    List<Idea> findByApprovedFalse();
}
