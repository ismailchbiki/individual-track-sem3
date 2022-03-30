package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

public interface KiteLessonBusiness {
    KiteLessonDTO createKiteLesson(KiteLessonDTO kiteLessonDTO);
    KiteLessonDTO updateKiteLesson(long id, KiteLessonDTO newKiteLessonDTO);
    void deleteKiteLesson(long id);
}
