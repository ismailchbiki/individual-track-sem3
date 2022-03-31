package ismail.myapplication.business.impl;

import ismail.myapplication.business.useCase.CreateKiteLessonUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CreateKiteLessonUseCaseImpl implements CreateKiteLessonUseCase {

    private KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO createKiteLesson(KiteLessonDTO kiteLessonDTO) {
        KiteLesson kiteLesson = kiteLessonRepository.save(KiteLessonDTOConverter.convertDTOToEntity(kiteLessonDTO));
        return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
    }
}
