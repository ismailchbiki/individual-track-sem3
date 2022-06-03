package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.dto.kiteLesson.GetAllKiteLessonsResponseDTO;
import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.service.kiteLesson.GetAllKiteLessonsUseCase;
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
