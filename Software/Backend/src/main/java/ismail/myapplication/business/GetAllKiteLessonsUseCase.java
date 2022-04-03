package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

import java.util.List;

public interface GetAllKiteLessonsUseCase {
    List<KiteLessonDTO> getKiteLessonsDTO();
}
