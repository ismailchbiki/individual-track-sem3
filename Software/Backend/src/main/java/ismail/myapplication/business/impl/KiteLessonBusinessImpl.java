package ismail.myapplication.business.impl;

import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KiteLessonBusinessImpl implements KiteLessonBusiness {

    private KiteLessonRepository kiteLessonRepository;

    @Override
    public KiteLessonDTO createKiteLesson(KiteLessonDTO kiteLessonDTO) {
        KiteLesson kiteLesson = kiteLessonRepository.save(KiteLessonDTOConverter.convertDTOToEntity(kiteLessonDTO));
        return KiteLessonDTOConverter.convertEntityToDTO(kiteLesson);
    }

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

    @Override
    public void
    deleteKiteLesson(long id) {
        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kite lesson with this id:" + id + " doesn't exist."));
        kiteLessonRepository.delete(existingKiteLesson);
    }
}
