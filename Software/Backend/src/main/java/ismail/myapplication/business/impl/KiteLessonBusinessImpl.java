/*
package ismail.myapplication.business.impl;

import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiteLessonBusinessImpl implements KiteLessonBusiness {

    private KiteLessonRepository kiteLessonRepo;

    public KiteLessonBusinessImpl(KiteLessonRepository kiteLessonRepo) {
        this.kiteLessonRepo = kiteLessonRepo;
    }

    @Override
    public List<KiteLessonDTO> findAll(){
        return kiteLessonRepo.findAll();
    }

    @Override
    public KiteLessonDTO findByType(String type){
        return findAll().stream().filter(kite -> kite.getType().equals(type)).findFirst().orElse(null);
    }

    @Override
    public KiteLessonDTO create(KiteLessonDTO kiteLessonDTO){
        kiteLessonRepo.create(kiteLessonDTO);
        return kiteLessonDTO;
    }

    @Override
    public void update(KiteLessonDTO newKiteLessonDTO, String type){
        KiteLessonDTO existingLesson = kiteLessonRepo.findAll().stream().filter(lesson -> lesson.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> (new IllegalArgumentException("Not Found")));

        int i = kiteLessonRepo.findAll().indexOf(existingLesson);
        kiteLessonRepo.findAll().set(i, newKiteLessonDTO);
    }

    @Override
    public void delete(String type){
        kiteLessonRepo.findAll().removeIf(lesson -> lesson.getType().equals(type));
    }
}
*/
