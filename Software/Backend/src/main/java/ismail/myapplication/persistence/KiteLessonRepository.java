package ismail.myapplication.persistence;

import ismail.myapplication.model.KiteLesson;

import java.util.List;

public interface KiteLessonRepository {
    List<KiteLesson> findAll();
    KiteLesson create(KiteLesson kiteLesson);
    void update(KiteLesson newKiteLesson, String type);
    void delete(String type);
}
