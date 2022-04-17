package ismail.myapplication.business;

import ismail.myapplication.dto.CreateKiteLessonRequestDTO;
import ismail.myapplication.dto.CreateKiteLessonResponseDTO;

public interface CreateKiteLessonUseCase {
    CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request);
}