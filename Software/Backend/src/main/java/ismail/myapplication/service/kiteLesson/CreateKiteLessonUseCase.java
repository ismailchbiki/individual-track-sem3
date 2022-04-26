package ismail.myapplication.service.kiteLesson;

import ismail.myapplication.dto.kiteLesson.CreateKiteLessonRequestDTO;
import ismail.myapplication.dto.kiteLesson.CreateKiteLessonResponseDTO;

public interface CreateKiteLessonUseCase {
    CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request);
}