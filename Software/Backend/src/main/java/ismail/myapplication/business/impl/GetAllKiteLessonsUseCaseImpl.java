package ismail.myapplication.business.impl;

import ismail.myapplication.business.GetAllKiteLessonsUseCase;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllKiteLessonsUseCaseImpl implements GetAllKiteLessonsUseCase {

    private final KiteLessonRepository kiteLessonRepository;
    @Override
    public List<KiteLessonDTO> getKiteLessonsDTO(){
        List<KiteLesson> kiteLessons = kiteLessonRepository.findAll();

        ModelMapper mapper = new ModelMapper();
        return Arrays.asList(mapper.map(kiteLessons, KiteLessonDTO[].class));
    }
}
