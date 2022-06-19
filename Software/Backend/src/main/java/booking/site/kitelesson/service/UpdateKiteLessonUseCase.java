package booking.site.kitelesson.service;

import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;

public interface UpdateKiteLessonUseCase {
    void updateKiteLesson(CreateKiteLessonRequestDTO request);
}
