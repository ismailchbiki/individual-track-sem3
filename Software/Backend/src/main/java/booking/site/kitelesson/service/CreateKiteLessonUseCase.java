package booking.site.kitelesson.service;

import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;
import booking.site.kitelesson.dto.CreateKiteLessonResponseDTO;

public interface CreateKiteLessonUseCase {
    CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request);
}