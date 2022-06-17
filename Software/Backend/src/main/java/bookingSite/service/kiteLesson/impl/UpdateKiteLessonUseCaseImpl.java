package bookingSite.service.kiteLesson.impl;

import bookingSite.dto.kiteLesson.UpdateKiteLessonRequestDTO;
import bookingSite.exception.ResourceNotFoundException;
import bookingSite.repository.KiteLessonRepository;
import bookingSite.repository.entity.kiteLesson.KiteLesson;
import bookingSite.service.kiteLesson.UpdateKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateKiteLessonUseCaseImpl implements UpdateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public void updateKiteLesson(UpdateKiteLessonRequestDTO request) {

        Optional<KiteLesson> existingOptionalKiteLesson = kiteLessonRepository.findById(request.getId());
        if (existingOptionalKiteLesson.isEmpty()) {
            throw new ResourceNotFoundException("Kite lesson with this id:" + request.getId() + " is not found.");
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
