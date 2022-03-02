package ismail.myapplication.service;

import ismail.myapplication.model.KiteModel;
import ismail.myapplication.persistence.KiteLessonDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KiteLessonBusiness implements KiteLessonService {

    private KiteLessonDAO kiteLessonRepo;

    @Override
    public List<KiteModel> findAll(){
        return kiteLessonRepo.findAll();
    }

    @Override
    public KiteModel findByType(String type){
        return findAll().stream().filter(kite -> kite.getType().equals(type)).findFirst().orElse(null);
    }

    @Override
    public KiteModel create(KiteModel kiteLesson){
        kiteLessonRepo.create(kiteLesson);
        return kiteLesson;
    }

    @Override
    public void update(KiteModel newKiteLesson, String type){
        KiteModel existingLesson = kiteLessonRepo.findAll().stream().filter(lesson -> lesson.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> (new IllegalArgumentException("Not Found")));

        int i = kiteLessonRepo.findAll().indexOf(existingLesson);
        kiteLessonRepo.findAll().set(i, newKiteLesson);
    }

    @Override
    public void delete(String type){
        kiteLessonRepo.findAll().removeIf(lesson -> lesson.getType().equals(type));
    }
}
