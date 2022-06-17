package booking.site.repository;

import booking.site.repository.entity.kite_lesson.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {
    KiteLesson findByType(String type);

    boolean existsByType(String type);
}
