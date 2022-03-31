package ismail.myapplication.business.useCase;

import ismail.myapplication.dto.KiteLessonDTO;

import java.util.List;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);
    KiteLessonDTO getKiteLessonByType(String lessonType);
    List<KiteLessonDTO> GetKiteLessons();
}
