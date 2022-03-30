package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);
    KiteLessonDTO getKiteLessonByType(String lessonType);
}
