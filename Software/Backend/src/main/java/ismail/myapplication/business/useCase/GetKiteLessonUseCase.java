package ismail.myapplication.business.useCase;

import ismail.myapplication.dto.GetKiteLessonsDTO;
import ismail.myapplication.dto.KiteLessonDTO;

public interface GetKiteLessonUseCase {
    KiteLessonDTO getKiteLessonById(long lessonId);
    KiteLessonDTO getKiteLessonByType(String lessonType);
    GetKiteLessonsDTO GetKiteLessons();
}
