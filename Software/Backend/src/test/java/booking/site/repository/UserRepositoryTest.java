package booking.site.repository;

import booking.site.repository.entity.user.Role;
import booking.site.repository.entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    private Collection<Role> roles;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void before() {
        roles = new ArrayList<>();
        Role role = new Role(1L, "USER");
        roles.add(role);
    }

    @Test
    void save_shouldSaveNewUserWithAllFields() {

        //create object
        User user = User.builder()
                .email("ismail@email.com")
                .password("password")
                .roles(roles)
                .build();

        //save object
        User savedUser = userRepository.save(user);
        //check object is saved
        assertNotNull(savedUser.getId());
        //get object
        savedUser = entityManager.find(User.class, savedUser.getId());
        User expectedUser = User.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .roles(savedUser.getRoles())
                .build();

        //assert
        assertThat(savedUser)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedUser);
    }

    @Test
    void findByEmail_shouldReturnUser_whenItExists() {

        entityManager.persist(User.builder()
                .email("ismail@email.com")
                .password("password")
                .build());

        User actualUser = userRepository.findByEmail("ismail@email.com");

        assertNotNull(actualUser.getId());
        User expectedUser = User.builder()
                .email("ismail@email.com")
                .password("password")
                .build();
        assertThat(actualUser)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedUser);
    }

    @Test
    void findByEmail_shouldReturnNull_whenEmailNotFound() {
        User actualUser = userRepository.findByEmail("null");
        assertNull(actualUser);
    }
}