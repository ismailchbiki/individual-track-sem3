package bookingSite.service.kiteLesson;

import bookingSite.dto.kiteLesson.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);

    KiteLessonDTO getKiteLessonByType(String lessonType);
}
