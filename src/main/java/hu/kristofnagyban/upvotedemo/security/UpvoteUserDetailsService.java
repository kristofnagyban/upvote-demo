package hu.kristofnagyban.upvotedemo.security;

import hu.kristofnagyban.upvotedemo.domain.User;
import hu.kristofnagyban.upvotedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpvoteUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UpvoteUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return user.map(UpvoteUserDetails::new).get();
    }
}
