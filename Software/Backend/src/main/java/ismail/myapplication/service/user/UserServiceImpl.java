package ismail.myapplication.service.user;

import ismail.myapplication.dto.user.UserCreateRequest;
import ismail.myapplication.repository.UserRepository;
import ismail.myapplication.repository.entity.user.Role;
import ismail.myapplication.repository.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;
    @Lazy
    final private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(UserCreateRequest userCreateRequest) {

        User user = new User();
        Optional<User> byUserName = userRepository.findByUserName(userCreateRequest.getUserName());
        if (byUserName.isPresent()) {
            throw new RuntimeException("User already registered. Please use different username.");
        }

        user = User.builder()
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .userName(userCreateRequest.getUserName())
                .email(userCreateRequest.getEmail())
                .password(passwordEncoder.encode(userCreateRequest.getPassword()))
                .roles(Arrays.asList(new Role("ROLE_USER")))
                .build();

        userRepository.save(user);
        return null;
    }

    @Override
    public User loadUserByUsername (String username) {
        return userRepository.findByUserName(username).orElseThrow(EntityNotFoundException::new);
    }
}
