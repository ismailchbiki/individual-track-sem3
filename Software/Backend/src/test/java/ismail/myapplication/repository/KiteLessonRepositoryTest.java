package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class KiteLessonRepositoryTest {

    @Autowired
    private KiteLessonRepository kiteLessonRepository;

    @BeforeEach
    void setUp(){
        kiteLessonRepository.deleteAll();
    }

    @Test
    void saveKiteLessonTest_shouldSaveKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());
        KiteLesson kiteLesson = KiteLesson.builder()
                .type("repository-test-type")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();

        kiteLessonRepository.save(kiteLesson);

        assertThat(kiteLesson.getId()).isPositive();
    }

    @Test
    void getKiteLessonByIdTest_shouldReturnKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());
        KiteLesson kiteLesson = kiteLessonRepository.getById(66L);
        assertThat(kiteLesson.getId()).isEqualTo(66L);
    }

    @Test
    void getKiteLessonByTypeTest_shouldReturnKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());

        //arrange
        KiteLesson kiteLesson = KiteLesson.builder()
                .type("private-lesson")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();

        //act
        kiteLessonRepository.save(kiteLesson);
        assertThat(kiteLessonRepository.findAll()).hasSize(1);

        //assert
        assertThat(kiteLesson.getType()).isEqualTo("private-lesson");
    }

    @Test
    void getAllKiteLessonsTest_shouldReturnAllKiteLessons(){
        assertThat(kiteLessonRepository.findAll().isEmpty());

        KiteLesson kiteLesson1 = KiteLesson.builder()
                .type("repository-test-type")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();

        KiteLesson kiteLesson2 = KiteLesson.builder()
                .type("repository-test-type")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();

        kiteLessonRepository.save(kiteLesson1);
        kiteLessonRepository.save(kiteLesson2);
        assertThat(kiteLessonRepository.findAll()).hasSize(2);
    }

    @Test
    void updateKiteLessonTest_shouldUpdateKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());

        //save kite lesson to update
        KiteLesson existingKiteLesson = KiteLesson.builder()
                .type("repository-test-type")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();
        KiteLesson kiteLessonToUpdate = kiteLessonRepository.save(existingKiteLesson);

        //check if saved
        assertThat(kiteLessonRepository.findAll()).hasSize(1);
        assertThat(kiteLessonRepository.findById(1L).isPresent());

        //update kite lesson
        kiteLessonToUpdate.setType("repository-test-type-updated");
        kiteLessonToUpdate.setPersons(2);
        kiteLessonToUpdate.setHours(3D);
        kiteLessonToUpdate.setPrice(400D);

        //save updated kite lesson to db
        KiteLesson kiteLessonUpdated = kiteLessonRepository.save(kiteLessonToUpdate);

        //check if updated
        assertThat(kiteLessonUpdated.getType()).isEqualTo("repository-test-type-updated");
        assertThat(kiteLessonUpdated.getPersons()).isEqualTo(2);
        assertThat(kiteLessonUpdated.getHours()).isEqualTo(3D);
        assertThat(kiteLessonUpdated.getPrice()).isEqualTo(400D);
    }

    @Test
    void deleteKiteLessonTest_shouldDeleteKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());

        // find and delete kite lesson
        KiteLesson kiteLesson = kiteLessonRepository.getById(98L);
        kiteLessonRepository.delete(kiteLesson);

        KiteLesson kiteLessonNull = null;

        Optional<KiteLesson> deletedKiteLesson = kiteLessonRepository.findByType("private");

        if(deletedKiteLesson.isPresent()){
            kiteLessonNull = deletedKiteLesson.get();
        }

        assertThat(kiteLessonRepository.findAll().isEmpty());
        assertThat(kiteLessonNull).isNull();
    }

    @Test
    void deleteAllKiteLessonTest_shouldDeleteAllKiteLesson(){
        assertThat(kiteLessonRepository.findAll().isEmpty());
        kiteLessonRepository.deleteAll();
        assertThat(kiteLessonRepository.findAll().isEmpty());
    }
}