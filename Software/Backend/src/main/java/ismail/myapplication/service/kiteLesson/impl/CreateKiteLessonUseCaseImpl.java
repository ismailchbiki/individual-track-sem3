package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.service.kiteLesson.CreateKiteLessonUseCase;
import ismail.myapplication.dto.kiteLesson.CreateKiteLessonRequestDTO;
import ismail.myapplication.dto.kiteLesson.CreateKiteLessonResponseDTO;
import ismail.myapplication.exception.KiteLessonTypeAlreadyExistsException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateKiteLessonUseCaseImpl implements CreateKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Transactional
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
