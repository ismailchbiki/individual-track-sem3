package ismail.myapplication.business;

import ismail.myapplication.model.KiteLesson;
import ismail.myapplication.persistence.KiteLessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiteLessonBusinessImpl implements KiteLessonBusiness {

    private KiteLessonRepository kiteLessonRepo;

    public KiteLessonBusinessImpl(KiteLessonRepository kiteLessonRepo) {
        this.kiteLessonRepo = kiteLessonRepo;
    }

    @Override
    public List<KiteLesson> findAll(){
        return kiteLessonRepo.findAll();
    }

    @Override
    public KiteLesson findByType(String type){
        return findAll().stream().filter(kite -> kite.getType().equals(type)).findFirst().orElse(null);
    }

    @Override
    public KiteLesson create(KiteLesson kiteLesson){
        kiteLessonRepo.create(kiteLesson);
        return kiteLesson;
    }

    @Override
    public void update(KiteLesson newKiteLesson, String type){
        KiteLesson existingLesson = kiteLessonRepo.findAll().stream().filter(lesson -> lesson.getType().equals(type))
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
