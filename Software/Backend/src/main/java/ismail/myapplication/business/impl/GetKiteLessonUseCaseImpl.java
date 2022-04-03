package ismail.myapplication.business.impl;

import ismail.myapplication.business.GetKiteLessonUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetKiteLessonUseCaseImpl implements GetKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO getKiteLessonById(long lessonId) {
        KiteLesson kiteLesson = kiteLessonRepository.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Kite Lesson is not found with Id: " + lessonId));

        return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
    }

    @Override
    public KiteLessonDTO getKiteLessonByType(String lessonType){
        for (KiteLesson kiteLesson : kiteLessonRepository.findAll()) {
            if (kiteLesson.getType().equals(lessonType)) {
                return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
            }else{
                throw new ResourceNotFoundException("Kite Lesson is not found with Type: " + lessonType);
            }
        }
        return null;
    }
}
