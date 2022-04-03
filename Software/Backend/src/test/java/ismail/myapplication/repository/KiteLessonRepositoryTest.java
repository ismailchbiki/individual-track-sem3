package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class KiteLessonRepositoryTest {

    @Autowired
    private KiteLessonRepository kiteLessonRepository;

    @Test
    public void saveKiteLessonTest_shouldSaveKiteLesson(){
        KiteLesson kiteLesson = KiteLesson.builder()
                .type("repository-test-type")
                .persons(1)
                .hours(2D)
                .price(300D)
                .build();

        kiteLessonRepository.save(kiteLesson);

        assertThat(kiteLesson.getId()).isGreaterThan(0);
    }

    @Test
    public void getKiteLessonByIdTest_shouldReturnKiteLesson(){
        KiteLesson kiteLesson = kiteLessonRepository.getById(66L);
        assertThat(kiteLesson.getId()).isEqualTo(66L);
    }
}