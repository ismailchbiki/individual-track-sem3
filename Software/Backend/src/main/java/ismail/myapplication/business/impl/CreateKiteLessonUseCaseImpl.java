package ismail.myapplication.business.impl;

import ismail.myapplication.business.CreateKiteLessonUseCase;
import ismail.myapplication.dto.CreateKiteLessonRequestDTO;
import ismail.myapplication.dto.CreateKiteLessonResponseDTO;
import ismail.myapplication.exception.KiteLessonTypeAlreadyExistsException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
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
