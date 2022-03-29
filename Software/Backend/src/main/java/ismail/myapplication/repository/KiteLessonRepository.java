package ismail.myapplication.repository;

import ismail.myapplication.dto.KiteLesson;

import java.util.List;

public interface KiteLessonRepository {
    List<KiteLesson> findAll();
    KiteLesson create(KiteLesson kiteLesson);
    void update(KiteLesson newKiteLesson, String type);
    void delete(String type);
}
