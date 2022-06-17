package booking.site.service.kite_lesson;

import booking.site.dto.kite_lesson.CreateKiteLessonRequestDTO;
import booking.site.dto.kite_lesson.CreateKiteLessonResponseDTO;

public interface CreateKiteLessonUseCase {
    CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request);
}