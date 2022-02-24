package ismail.individualtrackproject.business.Implementation;

import ismail.individualtrackproject.business.Interface.KiteLessonBusiness;
import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.dataLayer.Interface.KiteLessonDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KiteLessonBusinessImpl implements KiteLessonBusiness {

    @Autowired
    private KiteLessonDA _kiteLessonRepo;

    /*public KiteLessonBusinessImpl(KiteLessonDataAccess _kiteLessonRepo) {
        this._kiteLessonRepo = _kiteLessonRepo;
    }*/

    @Override
    public List<KiteModel> findAll(){
        return _kiteLessonRepo.findAll();
    }

    @Override
    public KiteModel findByType(String type){
        return findAll().stream().filter(kite -> kite.getType().equals(type)).findFirst().orElse(null);
    }

    @Override
    public KiteModel create(KiteModel kiteLesson){
        _kiteLessonRepo.create(kiteLesson);
        return kiteLesson;
    }

    @Override
    public void update(KiteModel newKiteLesson, String type){
        KiteModel existingLesson = _kiteLessonRepo.findAll().stream().filter(lesson -> lesson.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> (new IllegalArgumentException("Not Found")));

        int i = _kiteLessonRepo.findAll().indexOf(existingLesson);
        _kiteLessonRepo.findAll().set(i, newKiteLesson);
    }

    @Override
    public void delete(String type){
        _kiteLessonRepo.findAll().removeIf(lesson -> lesson.getType().equals(type));
    }
}
