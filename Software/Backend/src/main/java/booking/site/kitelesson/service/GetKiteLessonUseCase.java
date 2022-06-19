package booking.site.kitelesson.service;

import booking.site.kitelesson.dto.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);

    KiteLessonDTO getKiteLessonByType(String lessonType);
}
