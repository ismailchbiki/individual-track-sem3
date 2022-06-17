package bookingSite.service.kiteLesson.impl;

import bookingSite.dto.kiteLesson.GetAllKiteLessonsResponseDTO;
import bookingSite.dto.kiteLesson.KiteLessonDTO;
import bookingSite.repository.KiteLessonRepository;
import bookingSite.service.kiteLesson.GetAllKiteLessonsUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllKiteLessonsUseCaseImpl implements GetAllKiteLessonsUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public GetAllKiteLessonsResponseDTO getKiteLessons() {
        List<KiteLessonDTO> kiteLessons = kiteLessonRepository.findAll()
                .stream()
                .map(KiteLessonDTOConverter::convertEntityToDTO)
                .toList();

        return GetAllKiteLessonsResponseDTO.builder()
                .kiteLessons(kiteLessons)
                .build();
    }
}
