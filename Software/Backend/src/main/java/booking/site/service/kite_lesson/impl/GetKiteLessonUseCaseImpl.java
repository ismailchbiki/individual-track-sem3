package booking.site.service.kite_lesson.impl;

import booking.site.dto.kite_lesson.KiteLessonDTO;
import booking.site.exception.ResourceNotFoundException;
import booking.site.repository.KiteLessonRepository;
import booking.site.repository.entity.kite_lesson.KiteLesson;
import booking.site.service.kite_lesson.GetKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetKiteLessonUseCaseImpl implements GetKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO getKiteLessonById(long lessonId) {
        KiteLesson kiteLesson = kiteLessonRepository.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Kite Lesson is not found with Id: " + lessonId));

        return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
    }

    @Override
    public KiteLessonDTO getKiteLessonByType(String lessonType) {
        KiteLesson kiteLesson = kiteLessonRepository.findByType(lessonType);

        if (kiteLesson == null) {
            throw new ResourceNotFoundException("Kite Lesson is not found with Id: " + lessonType);
        } else {
            return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
        }
    }
}
