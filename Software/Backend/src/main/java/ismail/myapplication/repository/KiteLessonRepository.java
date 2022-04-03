package ismail.myapplication.repository;

import ismail.myapplication.repository.entity.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {
    Optional<KiteLesson> findByType(String type);
}
