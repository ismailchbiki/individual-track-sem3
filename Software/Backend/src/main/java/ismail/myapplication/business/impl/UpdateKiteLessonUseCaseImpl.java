package ismail.myapplication.business.impl;

import ismail.myapplication.business.UpdateKiteLessonUseCase;
import ismail.myapplication.dto.UpdateKiteLessonRequestDTO;
import ismail.myapplication.exception.InvalidKiteLessonException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateKiteLessonUseCaseImpl implements UpdateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Transactional
    @Override
    public void updateKiteLesson(UpdateKiteLessonRequestDTO request) {

        Optional<KiteLesson> existingOptionalKiteLesson = kiteLessonRepository.findById(request.getId());
        if(existingOptionalKiteLesson.isEmpty()) {
            throw new InvalidKiteLessonException("KITE_LESSON_ID_INVALID");
            //throw new ResourceNotFoundException("No kite lesson with this id:" + request.getId() + " is found.");
        }

        KiteLesson kiteLesson = existingOptionalKiteLesson.get();
        updateFields(request, kiteLesson);
    }

    private void updateFields (UpdateKiteLessonRequestDTO request, KiteLesson kiteLesson){

        kiteLesson.setType(request.getType());
        kiteLesson.setHours(request.getHours());
        kiteLesson.setPersons(request.getPersons());
        kiteLesson.setPrice(request.getPrice());

        kiteLessonRepository.save(kiteLesson);
    }
}
