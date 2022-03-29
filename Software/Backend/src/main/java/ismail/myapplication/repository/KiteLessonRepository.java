package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

//This will have all crud methods to operate on the DB
public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {
    /*List<KiteLessonDTO> findAll();
    KiteLessonDTO create(KiteLessonDTO kiteLessonDTO);
    void update(KiteLessonDTO newKiteLessonDTO, String type);
    void delete(String type);*/
}
