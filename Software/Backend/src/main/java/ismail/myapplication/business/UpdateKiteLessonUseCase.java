package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

public interface UpdateKiteLessonUseCase {
    KiteLessonDTO updateKiteLesson(long id, KiteLessonDTO newKiteLessonDTO);
}
