package bookingSite.service.kiteLesson.impl;

import bookingSite.dto.kiteLesson.CreateKiteLessonRequestDTO;
import bookingSite.dto.kiteLesson.CreateKiteLessonResponseDTO;
import bookingSite.exception.KiteLessonTypeAlreadyExistsException;
import bookingSite.repository.KiteLessonRepository;
import bookingSite.repository.entity.kiteLesson.KiteLesson;
import bookingSite.service.kiteLesson.CreateKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class CreateKiteLessonUseCaseImpl implements CreateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public CreateKiteLessonResponseDTO createKiteLesson(CreateKiteLessonRequestDTO request) {

        if (kiteLessonRepository.existsByType(request.getType())) {
            throw new KiteLessonTypeAlreadyExistsException();
        }

        KiteLesson kiteLesson = KiteLesson.builder()
                .type(request.getType())
                .hours(request.getHours())
                .persons(request.getPersons())
                .price(request.getPrice())
                .build();

        KiteLesson savedKiteLesson = kiteLessonRepository.save(kiteLesson);

        return CreateKiteLessonResponseDTO.builder()
                .kiteLessonId(savedKiteLesson.getId())
                .build();
    }
}
