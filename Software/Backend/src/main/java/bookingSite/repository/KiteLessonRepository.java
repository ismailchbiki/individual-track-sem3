package bookingSite.repository;

import bookingSite.repository.entity.kiteLesson.KiteLesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KiteLessonRepository extends JpaRepository<KiteLesson, Long> {
    KiteLesson findByType(String type);

    boolean existsByType(String type);
}
