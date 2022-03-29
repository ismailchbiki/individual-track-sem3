package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

import java.util.List;

public interface KiteLessonBusiness {
    List<KiteLessonDTO> findAllKiteLessons();
    KiteLessonDTO findKiteLessonById(long id);
    KiteLessonDTO findKiteLessonByType(String type);
    KiteLessonDTO createKiteLesson(KiteLessonDTO kiteLessonDTO);
    KiteLessonDTO updateKiteLesson(long id, KiteLessonDTO newKiteLessonDTO);
    void deleteKiteLesson(long id);
}
