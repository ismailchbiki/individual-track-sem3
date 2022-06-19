package booking.site.user;

import booking.site.user.entity.Role;
import booking.site.user.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void save_shouldSaveRoleWithAllFields() {

        //create object
        Role role = Role.builder()
                .name("MANAGER")
                .build();

        //save object
        Role savedRole = roleRepository.save(role);
        //check object is saved
        assertNotNull(savedRole.getId());
        //get object
        savedRole = entityManager.find(Role.class, savedRole.getId());
        Role expectedRole = Role.builder()
                .name("MANAGER")
                .build();

        //assert
        assertThat(savedRole)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedRole);
    }
}