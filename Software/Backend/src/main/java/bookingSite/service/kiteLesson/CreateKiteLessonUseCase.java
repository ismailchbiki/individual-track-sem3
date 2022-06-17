package bookingSite.service.kiteLesson;

import bookingSite.dto.kiteLesson.CreateKiteLessonRequestDTO;
import bookingSite.dto.kiteLesson.CreateKiteLessonResponseDTO;

public interface CreateKiteLessonUseCase {
    CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request);
}