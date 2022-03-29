/*
package ismail.myapplication.repository;

import ismail.myapplication.dto.KiteLessonDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KiteLessonRepositoryImpl implements KiteLessonRepository {
    private final List<KiteLessonDTO> kiteLessonDTOS = new ArrayList<>();

    public KiteLessonRepositoryImpl() {
        */
/*KiteLessonDTO privateLesson = new KiteLessonDTO("private", 2, 1, 150.0);
        KiteLessonDTO semiPrivateLesson = new KiteLessonDTO("semi private", 2, 2, 100.0);
        KiteLessonDTO groupLesson = new KiteLessonDTO("group", 2, 4, 60.0);

        kiteLessonDTOS.add(privateLesson);
        kiteLessonDTOS.add(semiPrivateLesson);
        kiteLessonDTOS.add(groupLesson);*//*

    }

    @Override
    public List<KiteLessonDTO> findAll(){
        return kiteLessonDTOS;
    }

    @Override
    public KiteLessonDTO create(KiteLessonDTO kiteLessonDTO){
        kiteLessonDTOS.add(kiteLessonDTO);
        return kiteLessonDTO;
    }

    @Override
    public void update(KiteLessonDTO newKiteLessonDTO, String type){
        KiteLessonDTO existingLesson = kiteLessonDTOS.stream().filter(lesson -> lesson.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> (new IllegalArgumentException("Not Found")));

        int i = kiteLessonDTOS.indexOf(existingLesson);
        kiteLessonDTOS.set(i, newKiteLessonDTO);
    }

    @Override
    public void delete(String type){
        kiteLessonDTOS.removeIf(lesson -> lesson.getType().equals(type));
    }
}
*/
