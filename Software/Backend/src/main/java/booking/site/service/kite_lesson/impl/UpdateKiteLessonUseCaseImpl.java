package booking.site.service.kite_lesson.impl;

import booking.site.dto.kite_lesson.UpdateKiteLessonRequestDTO;
import booking.site.exception.ResourceNotFoundException;
import booking.site.repository.KiteLessonRepository;
import booking.site.repository.entity.kite_lesson.KiteLesson;
import booking.site.service.kite_lesson.UpdateKiteLessonUseCase;
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
