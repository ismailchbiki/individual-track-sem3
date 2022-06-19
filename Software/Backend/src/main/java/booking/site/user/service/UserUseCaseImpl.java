package booking.site.user.service;

import booking.site.user.dto.RoleDTO;
import booking.site.user.dto.UserDTO;
import booking.site.user.entity.Role;
import booking.site.user.entity.User;
import booking.site.user.repository.RoleRepository;
import booking.site.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor/*(onConstructor = @__(@Lazy))*/
public class UserUseCaseImpl implements UserUseCase, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    //this method tells to spring how to find a user
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //looping over all the roles of this user,
        //and for every single role of them,
        //create a SimpleGrantAuthority by passing the role name and add it to the list
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

        //then pass everything to spring security
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        log.info("saving the user {} to the DB", userDTO.getEmail());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User user = User.builder()
                .id(userDTO.getId())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .roles(userDTO.getRoles())
                .build();

        User savedUser = userRepository.save(user);
        return UserDTO.builder().id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .roles(userDTO.getRoles())
                .build();
    }

    @Override
    public RoleDTO saveRole(RoleDTO roleDTO) {
        log.info("saving new role {} to the DB", roleDTO.getName());
        Role role = Role.builder()
                .id(roleDTO.getId())
                .name(roleDTO.getName())
                .build();
        Role savedRole = roleRepository.save(role);
        return RoleDTO.builder()
                .id(savedRole.getId())
                .name(savedRole.getName())
                .build();
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepository.findByEmail(username);
        Role role = roleRepository.findByName(roleName);
        //add new role to the user,
        //and save everything to the DB (@transactional)
        user.getRoles().add(role);
    }

    @Override
    public UserDTO getUser(String username) {
        log.info("Fetching user {}", username);
        User user = userRepository.findByEmail(username);
        return UserDTO.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Fetching all users");

        return userRepository.findAll()
                .stream()
                .map(UserDTOConverter::convertEntityToDTO)
                .toList();
    }
}
