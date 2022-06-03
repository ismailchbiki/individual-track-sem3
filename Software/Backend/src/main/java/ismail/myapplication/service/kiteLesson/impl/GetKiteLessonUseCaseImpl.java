package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import ismail.myapplication.service.kiteLesson.GetKiteLessonUseCase;
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

//        KiteLessonDTO kiteLessonDTO = null;
//        for (KiteLesson kiteLesson : kiteLessonRepository.findAll()) {
//            if (kiteLesson.getType().equals(lessonType)) {
//                kiteLessonDTO = KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
//            }else{
//                throw new ResourceNotFoundException("Kite Lesson is not found with Type: " + lessonType);
//            }
//        }
//        return kiteLessonDTO;
    }
}
