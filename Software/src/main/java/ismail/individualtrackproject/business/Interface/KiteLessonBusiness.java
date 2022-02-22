package ismail.individualtrackproject.business.Interface;

import ismail.individualtrackproject.model.KiteModel;

import java.util.List;

public interface KiteLessonBusiness {
    List<KiteModel> findAll();
    KiteModel findByType(String type);
    KiteModel create(KiteModel kiteLesson);
    void update(KiteModel newKiteLesson, String type);
    void delete(String type);
}
