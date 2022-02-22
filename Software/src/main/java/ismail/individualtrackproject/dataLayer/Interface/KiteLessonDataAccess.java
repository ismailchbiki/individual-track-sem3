package ismail.individualtrackproject.dataLayer.Interface;

import ismail.individualtrackproject.model.KiteModel;

import java.util.List;

public interface KiteLessonDataAccess {
    List<KiteModel> findAll();
    KiteModel create(KiteModel kiteLesson);
    void update(KiteModel newKiteLesson, String type);
    void delete(String type);
}
