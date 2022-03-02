package ismail.myapplication.persistence;

import ismail.myapplication.model.KiteModel;

import java.util.List;

public interface KiteLessonDAO {
    List<KiteModel> findAll();
    KiteModel create(KiteModel kiteLesson);
    void update(KiteModel newKiteLesson, String type);
    void delete(String type);
}
