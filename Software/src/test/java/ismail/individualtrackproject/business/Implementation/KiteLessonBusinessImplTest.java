package ismail.individualtrackproject.business.Implementation;

import ismail.individualtrackproject.business.Interface.KiteLessonBusiness;
import ismail.individualtrackproject.dataLayer.Interface.KiteLessonDA;
import ismail.individualtrackproject.model.KiteModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KiteLessonBusinessImplTest {

    @Autowired
    KiteLessonBusiness kiteLesson;
    KiteModel privateLesson;

    /*@BeforeEach
    void setUp(){
        kiteLesson = new KiteLessonBusinessImpl();
    }*/


    @Test
    void findByType() {
        //Arrange
        Object lesson = kiteLesson.findByType("private");
        //Act

        //Assert
        Assertions.assertNotEquals(lesson, null);
    }

    @Test
    void create() {
        //Arrange
        privateLesson = new KiteModel("private", 2, 1, 150.0);

        //Act
        kiteLesson.findAll().add(privateLesson);
        int size = kiteLesson.findAll().size();

        //Assert
        Assertions.assertEquals(size, 4);
    }

    @Test
    void findAll() {
        //Arrange
        int size = kiteLesson.findAll().size();
        //Act

        //Assert
        Assertions.assertEquals(size, 4);
    }

    @Test
    void update() {
        //Arrange
        privateLesson = new KiteModel("collective", 3, 4, 50.0);

        //Act
        kiteLesson.update(privateLesson, "group");
        KiteModel newLessonType = kiteLesson.findByType("collective");

        //Assert
        Assertions.assertNotEquals(newLessonType, null);
        Assertions.assertEquals(newLessonType.getPeople(), 4);
        Assertions.assertEquals(newLessonType.getHours(), 3);
    }

    @Test
    void delete() {
        //Arrange
        kiteLesson.delete("collective");

        //Act
        KiteModel newLessonType = kiteLesson.findByType("collective");

        //Assert
        Assertions.assertNull(newLessonType);
    }
}