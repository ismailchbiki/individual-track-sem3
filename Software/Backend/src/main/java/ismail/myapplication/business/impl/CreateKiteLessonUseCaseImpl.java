package ismail.myapplication.business.impl;

import ismail.myapplication.business.CreateKiteLessonUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateKiteLessonUseCaseImpl implements CreateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO createKiteLesson(KiteLessonDTO kiteLessonDTO) {
        KiteLesson kiteLesson = kiteLessonRepository.save(KiteLessonDTOConverter.convertDTOToEntity(kiteLessonDTO));
        return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
    }
}
