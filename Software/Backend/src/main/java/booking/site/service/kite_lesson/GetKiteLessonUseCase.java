package booking.site.service.kite_lesson;

import booking.site.dto.kite_lesson.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);

    KiteLessonDTO getKiteLessonByType(String lessonType);
}
