package ismail.myapplication.business;

import ismail.myapplication.model.KiteLesson;

import java.util.List;

public interface KiteLessonBusiness {
    List<KiteLesson> findAll();
    KiteLesson findByType(String type);
    KiteLesson create(KiteLesson kiteLesson);
    void update(KiteLesson newKiteLesson, String type);
    void delete(String type);
}
