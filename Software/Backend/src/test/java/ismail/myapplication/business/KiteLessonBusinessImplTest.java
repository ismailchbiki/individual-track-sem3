package ismail.myapplication.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KiteLessonBusinessImplTest {

    @Test
    void contextLoads() {
    }


    /*private KiteLesson lesson;
    private KiteLessonBusiness kiteLessonBusiness;

    public KiteLessonBusinessImplTest(KiteLessonBusiness kiteLessonBusiness) {
        this.kiteLessonBusiness = kiteLessonBusiness;
    }

    *//*@BeforeEach
    void setUp(){
        kiteLessonBusiness = kiteLessonBusiness;
    }*//*

    @Test
    void findByType() {
        //Arrange
        Object lesson = kiteLessonBusiness.findByType("private");
        //Act

        //Assert
        Assertions.assertNotEquals(lesson, null);
    }

    @Test
    void create() {
        //Arrange
        lesson = new KiteLesson("private", 2, 1, 150.0);

        //Act
        kiteLessonBusiness.findAll().add(lesson);
        int size = kiteLessonBusiness.findAll().size();

        //Assert
        Assertions.assertEquals(size, 4);
    }

    @Test
    void findAll() {
        //Arrange
        int size = kiteLessonBusiness.findAll().size();
        //Act

        //Assert
        Assertions.assertEquals(size, 4);
    }

    @Test
    void update() {
        //Arrange
        lesson = new KiteLesson("collective", 3, 4, 50.0);

        //Act
        kiteLessonBusiness.update(lesson, "group");
        KiteLesson newLessonType = kiteLessonBusiness.findByType("collective");

        //Assert
        Assertions.assertNotEquals(newLessonType, null);
        Assertions.assertEquals(newLessonType.getPeople(), 4);
        Assertions.assertEquals(newLessonType.getHours(), 3);
    }

    @Test
    void delete() {
        //Arrange
        kiteLessonBusiness.delete("collective");

        //Act
        KiteLesson newLessonType = kiteLessonBusiness.findByType("collective");

        //Assert
        Assertions.assertNull(newLessonType);
    }*/
}