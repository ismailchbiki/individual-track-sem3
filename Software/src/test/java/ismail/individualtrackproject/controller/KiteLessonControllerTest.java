package ismail.individualtrackproject.controller;

import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.repository.KiteLessonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KiteLessonControllerTest {

    @Test
    void findAll() {
        //Arrange
        KiteLessonController controller = new KiteLessonController(new KiteLessonRepository());
        //Act
        Integer response = controller.findAll().size();
        //Assert
        assertEquals(response, 3);
    }

    @Test
    void findByType_private() {
        //Arrange
        KiteLessonController controller = new KiteLessonController(new KiteLessonRepository());
        //Act
        KiteModel response = controller.findByType("private");
        //Assert
        assertNotNull(response);
    }

    @Test
    void findByType_group() {
        //Arrange
        KiteLessonController controller = new KiteLessonController(new KiteLessonRepository());
        //Act
        KiteModel response = controller.findByType("group");
        //Assert
        assertNotNull(response);
    }

    @Test
    void findByType_semiPrivate() {
        //Arrange
        KiteLessonController controller = new KiteLessonController(new KiteLessonRepository());
        //Act
        KiteModel response = controller.findByType("semi private");
        //Assert
        assertNotNull(response);
    }

    /*@Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }*/
}