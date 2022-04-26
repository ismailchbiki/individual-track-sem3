package ismail.myapplication.service.kiteLesson;

import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);
    KiteLessonDTO getKiteLessonByType(String lessonType);
}
