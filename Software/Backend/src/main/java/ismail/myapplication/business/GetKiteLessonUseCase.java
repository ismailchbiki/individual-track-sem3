package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

import java.util.List;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);
    KiteLessonDTO getKiteLessonByType(String lessonType);
    List<KiteLessonDTO> GetKiteLessonsDTO();
}
