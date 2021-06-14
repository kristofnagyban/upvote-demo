package hu.kristofnagyban.upvotedemo.repository;

import hu.kristofnagyban.upvotedemo.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
