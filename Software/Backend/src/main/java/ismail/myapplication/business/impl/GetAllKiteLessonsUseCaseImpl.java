package ismail.myapplication.business.impl;

import ismail.myapplication.business.GetAllKiteLessonsUseCase;
import ismail.myapplication.dto.GetAllKiteLessonsResponseDTO;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllKiteLessonsUseCaseImpl implements GetAllKiteLessonsUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public GetAllKiteLessonsResponseDTO getKiteLessons(){
        List<KiteLessonDTO> kiteLessons = kiteLessonRepository.findAll()
                .stream()
                .map(KiteLessonDTOConverter::convertEntityToDTO)
                .toList();

        return GetAllKiteLessonsResponseDTO.builder()
                .kiteLessons(kiteLessons)
                .build();
    }
}
