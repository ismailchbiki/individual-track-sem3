package ismail.myapplication.business.impl;

import ismail.myapplication.business.UpdateKiteLessonUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateKiteLessonUseCaseImpl implements UpdateKiteLessonUseCase {

    private KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO updateKiteLesson(long id, KiteLessonDTO newKiteLessonDTO) {

        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No kite lesson with this id:" + id + " is found."));

        existingKiteLesson.setType(newKiteLessonDTO.getType());
        existingKiteLesson.setHours(newKiteLessonDTO.getHours());
        existingKiteLesson.setPersons(newKiteLessonDTO.getPersons());
        existingKiteLesson.setPrice(newKiteLessonDTO.getPrice());

        kiteLessonRepository.save(existingKiteLesson);

        return KiteLessonDTOConverter.convertEntityToDTO(existingKiteLesson);
    }
}
