package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class KiteLessonRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private KiteLessonRepository kiteLessonRepository;

    @Test
    void findById_shouldReturnKiteLesson_whenItExists() {

        // given
        KiteLesson actualKiteLesson = KiteLesson.builder()
                .id(35L)
                .hours(2D)
                .persons(2)
                .price(100D)
                .type("testkitelesson")
                .build();
        assertNotNull(actualKiteLesson);
        kiteLessonRepository.save(actualKiteLesson);
        // when
        //KiteLesson expectedKiteLesson = kiteLessonRepository.findById(35L);

        // then
        /*KiteLesson expectedKiteLesson = KiteLesson.builder()
                .id(35L)
                .hours(2D)
                .persons(2)
                .price(100D)
                .type("testkitelesson")
                .build();*/
    /*    assertThat(actualKiteLesson)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedKiteLesson);*/
    }
}