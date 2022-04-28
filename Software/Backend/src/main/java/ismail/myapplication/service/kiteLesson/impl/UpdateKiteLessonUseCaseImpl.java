package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.dto.kiteLesson.UpdateKiteLessonRequestDTO;
import ismail.myapplication.exception.InvalidKiteLessonException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import ismail.myapplication.service.kiteLesson.UpdateKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j /*log the output to the console*/
public class UpdateKiteLessonUseCaseImpl implements UpdateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public void updateKiteLesson(UpdateKiteLessonRequestDTO request) {

        Optional<KiteLesson> existingOptionalKiteLesson = kiteLessonRepository.findById(request.getId());
        if (existingOptionalKiteLesson.isEmpty()) {
            throw new InvalidKiteLessonException("KITE_LESSON_ID_INVALID");
            //throw new ResourceNotFoundException("No kite lesson with this id:" + request.getId() + " is found.");
        }

        KiteLesson kiteLesson = existingOptionalKiteLesson.get();
        updateFields(request, kiteLesson);
    }

    private void updateFields(UpdateKiteLessonRequestDTO request, KiteLesson kiteLesson) {

        kiteLesson.setType(request.getType());
        kiteLesson.setHours(request.getHours());
        kiteLesson.setPersons(request.getPersons());
        kiteLesson.setPrice(request.getPrice());

        kiteLessonRepository.save(kiteLesson);
    }
}
