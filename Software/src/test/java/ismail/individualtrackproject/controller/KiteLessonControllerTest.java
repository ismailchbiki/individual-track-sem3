package ismail.individualtrackproject.controller;

import ismail.individualtrackproject.model.KiteModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/*
*
* For Integration Testing for later (Not applied yet)
*
* */

@SpringBootTest
class KiteLessonControllerTest {

    @Autowired
    KiteLessonController controller;

    @Test
    void findAll() {
        //Arrange
        //Act
        Integer response = controller.findAll().size();
        //Assert
        assertEquals(response, 4);
    }

    @Test
    void findByType_private() {
        //Arrange
        //Act
        KiteModel response = controller.findByType("private");
        //Assert
        assertNotNull(response);
    }

    @Test
    void findByType_group() {
        //Arrange
        //Act
        KiteModel response = controller.findByType("group");
        //Assert
        assertNull(response);
    }

    @Test
    void findByType_semiPrivate() {
        //Arrange
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