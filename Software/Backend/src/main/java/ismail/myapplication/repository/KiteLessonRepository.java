package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {
    KiteLesson findByType(String type);
    boolean existsByType(String type);

    List<KiteLesson> findAllKiteLessonsByType_OrderByTypeAsc(String lessonType);
}
