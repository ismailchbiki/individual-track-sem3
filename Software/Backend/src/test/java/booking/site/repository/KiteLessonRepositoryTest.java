package booking.site.repository;

import booking.site.repository.entity.kite_lesson.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class KiteLessonRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private KiteLessonRepository kiteLessonRepository;


    @Test
    void save_shouldSaveKiteLessonWithAllFields() {

        //create object
        KiteLesson kiteLesson = KiteLesson.builder()
                .type("semi-prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();

        //save object
        KiteLesson savedKiteLesson = kiteLessonRepository.save(kiteLesson);
        //check object is saved
        assertNotNull(savedKiteLesson.getId());
        //get object
        savedKiteLesson = entityManager.find(KiteLesson.class, savedKiteLesson.getId());
        KiteLesson expectedKiteLesson = KiteLesson.builder()
                .id(savedKiteLesson.getId())
                .type(savedKiteLesson.getType())
                .persons(savedKiteLesson.getPersons())
                .hours(savedKiteLesson.getHours())
                .price(savedKiteLesson.getPrice())
                .build();

        //assert
        assertThat(savedKiteLesson)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedKiteLesson);
    }

    @Test
    void findByType_shouldReturnKiteLesson_whenItExists() {

        entityManager.persist(KiteLesson.builder()
                .type("prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build());

        KiteLesson actualKiteLesson = kiteLessonRepository.findByType("prive");
        assertNotNull(actualKiteLesson.getId());
        KiteLesson expectedKiteLesson = KiteLesson.builder()
                .type("prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        assertThat(actualKiteLesson)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(expectedKiteLesson);
    }

    @Test
    void findByType_shouldReturnNull_whenKiteLessonNotFound() {
        KiteLesson actualKiteLesson = kiteLessonRepository.findByType("prive");
        assertNull(actualKiteLesson);
    }

    @Test
    void existsByType_shouldReturnTrue_whenTypeFound() {

        entityManager.persist(KiteLesson.builder()
                .type("prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build());

        boolean actual = kiteLessonRepository.existsByType("prive");
        assertTrue(actual);
    }

    @Test
    void existsByType_shouldReturnFalse_whenTypeNotFound() {
        boolean actual = kiteLessonRepository.existsByType("null");
        assertFalse(actual);
    }
}