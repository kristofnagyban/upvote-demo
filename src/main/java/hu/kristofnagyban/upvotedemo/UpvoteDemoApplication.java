package hu.kristofnagyban.upvotedemo;

import hu.kristofnagyban.upvotedemo.repository.IdeaRepository;
import hu.kristofnagyban.upvotedemo.repository.UserRepository;
import hu.kristofnagyban.upvotedemo.repository.VoteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {IdeaRepository.class, UserRepository.class, VoteRepository.class})
public class UpvoteDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpvoteDemoApplication.class, args);
	}

}
