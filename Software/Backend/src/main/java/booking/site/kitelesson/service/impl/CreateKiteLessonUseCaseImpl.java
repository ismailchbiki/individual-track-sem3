package booking.site.kitelesson.service.impl;

import booking.site.exception.KiteLessonTypeAlreadyExistsException;
import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;
import booking.site.kitelesson.dto.CreateKiteLessonResponseDTO;
import booking.site.kitelesson.entity.KiteLesson;
import booking.site.kitelesson.repository.KiteLessonRepository;
import booking.site.kitelesson.service.CreateKiteLessonUseCase;
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
