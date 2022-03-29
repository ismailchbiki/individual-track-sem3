package ismail.myapplication.business;

import ismail.myapplication.dto.KiteLessonDTO;

import java.util.List;

public interface KiteLessonBusiness {
    List<KiteLessonDTO> findAll();
    KiteLessonDTO findByType(String type);
    KiteLessonDTO create(KiteLessonDTO kiteLessonDTO);
    void update(KiteLessonDTO newKiteLessonDTO, String type);
    void delete(String type);
}
