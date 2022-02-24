package ismail.individualtrackproject.dataLayer.Implementation;

import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.dataLayer.Interface.KiteLessonDA;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KiteLessonRepository implements KiteLessonDA {
    private List<KiteModel> kiteLessons = new ArrayList<>();

    public KiteLessonRepository() {
        KiteModel privateLesson = new KiteModel("private", 2, 1, 150.0);
        KiteModel semiPrivateLesson = new KiteModel("semi private", 2, 2, 100.0);
        KiteModel groupLesson = new KiteModel("group", 2, 4, 60.0);

        kiteLessons.add(privateLesson);
        kiteLessons.add(semiPrivateLesson);
        kiteLessons.add(groupLesson);
    }

    @Override
    public List<KiteModel> findAll(){
        return kiteLessons;
    }

    @Override
    public KiteModel create(KiteModel kiteLesson){
        kiteLessons.add(kiteLesson);
        return kiteLesson;
    }

    @Override
    public void update(KiteModel newKiteLesson, String type){
        KiteModel existingLesson = kiteLessons.stream().filter(lesson -> lesson.getType().equals(type))
                .findFirst()
                .orElseThrow(() -> (new IllegalArgumentException("Not Found")));

        int i = kiteLessons.indexOf(existingLesson);
        kiteLessons.set(i, newKiteLesson);
    }

    @Override
    public void delete(String type){
        kiteLessons.removeIf(lesson -> lesson.getType().equals(type));
    }
}
