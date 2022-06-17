package bookingSite.service.kiteLesson.impl;

import bookingSite.dto.kiteLesson.KiteLessonDTO;
import bookingSite.exception.ResourceNotFoundException;
import bookingSite.repository.KiteLessonRepository;
import bookingSite.repository.entity.kiteLesson.KiteLesson;
import bookingSite.service.kiteLesson.GetKiteLessonUseCase;
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

        if (kiteLesson.equals(null)) {
            throw new ResourceNotFoundException("Kite Lesson is not found with Id: " + lessonType);
        } else {
            return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
        }
    }
}
