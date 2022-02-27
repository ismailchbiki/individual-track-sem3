package ismail.myapplication.service;

import ismail.myapplication.model.KiteModel;

import java.util.List;

public interface KiteLessonService {
    List<KiteModel> findAll();
    KiteModel findByType(String type);
    KiteModel create(KiteModel kiteLesson);
    void update(KiteModel newKiteLesson, String type);
    void delete(String type);
}
