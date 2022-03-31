package ismail.myapplication.business.useCase;

import ismail.myapplication.dto.KiteLessonDTO;

public interface UpdateKiteLessonUseCase {
    KiteLessonDTO updateKiteLesson(long id, KiteLessonDTO newKiteLessonDTO);
}
