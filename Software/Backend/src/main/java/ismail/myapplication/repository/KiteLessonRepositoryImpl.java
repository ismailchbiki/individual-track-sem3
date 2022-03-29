package ismail.myapplication.repository;

import ismail.myapplication.dto.KiteLesson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class KiteLessonRepositoryImpl implements KiteLessonRepository {
    private final List<KiteLesson> kiteLessons = new ArrayList<>();

    public KiteLessonRepositoryImpl() {
        KiteLesson privateLesson = new KiteLesson("private", 2, 1, 150.0);
        KiteLesson semiPrivateLesson = new KiteLesson("semi private", 2, 2, 100.0);
        KiteLesson groupLesson = new KiteLesson("group", 2, 4, 60.0);

        kiteLessons.add(privateLesson);
        kiteLessons.add(semiPrivateLesson);
        kiteLessons.add(groupLesson);
    }

    @Override
    public List<KiteLesson> findAll(){
        return kiteLessons;
    }

    @Override
    public KiteLesson create(KiteLesson kiteLesson){
        kiteLessons.add(kiteLesson);
        return kiteLesson;
    }

    @Override
    public void update(KiteLesson newKiteLesson, String type){
        KiteLesson existingLesson = kiteLessons.stream().filter(lesson -> lesson.getType().equals(type))
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
