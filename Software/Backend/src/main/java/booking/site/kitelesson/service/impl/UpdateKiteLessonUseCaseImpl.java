package booking.site.kitelesson.service.impl;

import booking.site.exception.ResourceNotFoundException;
import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;
import booking.site.kitelesson.entity.KiteLesson;
import booking.site.kitelesson.repository.KiteLessonRepository;
import booking.site.kitelesson.service.UpdateKiteLessonUseCase;
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
    public void updateKiteLesson(CreateKiteLessonRequestDTO request) {

        Optional<KiteLesson> existingOptionalKiteLesson = kiteLessonRepository.findById(request.getId());
        if (existingOptionalKiteLesson.isEmpty()) {
            throw new ResourceNotFoundException("Kite lesson with this id:" + request.getId() + " is not found.");
        }

        KiteLesson kiteLesson = existingOptionalKiteLesson.get();
        updateFields(request, kiteLesson);
    }

    private void updateFields(CreateKiteLessonRequestDTO request, KiteLesson kiteLesson) {

        kiteLesson.setType(request.getType());
        kiteLesson.setHours(request.getHours());
        kiteLesson.setPersons(request.getPersons());
        kiteLesson.setPrice(request.getPrice());

        kiteLessonRepository.save(kiteLesson);
    }
}
