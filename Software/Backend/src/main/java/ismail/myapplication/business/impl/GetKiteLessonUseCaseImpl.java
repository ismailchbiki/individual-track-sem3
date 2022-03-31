package ismail.myapplication.business.impl;

import ismail.myapplication.business.GetKiteLessonUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class GetKiteLessonUseCaseImpl implements GetKiteLessonUseCase {

    private KiteLessonRepository kiteLessonRepository;

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

    @Override
    public List<KiteLessonDTO> GetKiteLessonsDTO(){
        List<KiteLesson> kiteLessons = kiteLessonRepository.findAll();

        ModelMapper mapper = new ModelMapper();
        return Arrays.asList(mapper.map(kiteLessons, KiteLessonDTO[].class));
    }
}
