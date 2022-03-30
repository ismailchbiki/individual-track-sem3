/*
package ismail.myapplication.repository;

import ismail.myapplication.AbstractContainerBaseTest;
import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // disable in-memory database support
class KiteLessonRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private KiteLessonRepository kiteLessonRepository;

    @Test
    public void givenKiteLessonObject_whenSave_thenReturnSavedObject() {
        //Arrange
        KiteLesson kiteLesson = KiteLesson.builder()
                .id(200L)
                .price(150.0)
                .persons(1)
                .type("test-lesson")
                .hours(2.0).build();
        //Act
        KiteLesson savedKiteLesson = kiteLessonRepository.save(kiteLesson);

        //Assert
        Assertions.assertNotNull(savedKiteLesson);
        Assertions.assertNotNull(savedKiteLesson.getId());
    }
}*/
