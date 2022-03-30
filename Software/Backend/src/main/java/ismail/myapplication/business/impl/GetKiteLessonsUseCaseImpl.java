package ismail.myapplication.business.impl;

import ismail.myapplication.business.GetKiteLessonsUseCase;
import ismail.myapplication.dto.GetKiteLessonsResponseDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class GetKiteLessonsUseCaseImpl implements GetKiteLessonsUseCase {

    private KiteLessonRepository kiteLessonRepository;

    @Override
    public GetKiteLessonsResponseDTO GetKiteLessons(){
        return GetKiteLessonsResponseDTO.builder()
                .kiteLessons((kiteLessonRepository.findAll()).stream()
                        .map(KiteLessonDTOConverter::convertEntityToDTO)
                        .toList()).build();
    }
}
