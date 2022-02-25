package ismail.individualtrackproject.business.Implementation;

import ismail.individualtrackproject.business.Interface.KiteLessonBusiness;
import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.dataLayer.Interface.KiteLessonDA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KiteLessonBusinessImpl implements KiteLessonBusiness {

    //@Autowired
    private KiteLessonDA kiteLessonRepo;

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
