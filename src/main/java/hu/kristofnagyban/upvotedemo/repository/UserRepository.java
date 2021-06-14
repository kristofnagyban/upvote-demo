package hu.kristofnagyban.upvotedemo.repository;

import hu.kristofnagyban.upvotedemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
