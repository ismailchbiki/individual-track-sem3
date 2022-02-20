package ismail.individualtrackproject.controller;

import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.repository.KiteLessonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/kitelessons")
public class KiteLessonController {

    private final KiteLessonRepository kiteLessonsRepo;

    public KiteLessonController(KiteLessonRepository repository) {
        this.kiteLessonsRepo = repository;
    }

    // Get Request: https://localhost:8080/kitelessons
    @GetMapping
    public List<KiteModel> findAll(){
        return kiteLessonsRepo.findAll();
    }

    // Get Request: https://localhost:8080/kitelessons/lessontype
    @GetMapping("/{type}")
    public KiteModel findByType(@PathVariable String type){
        return kiteLessonsRepo.findByType(type);
    }

    // Post Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.CREATED) //201 status code
    @PostMapping
    public KiteModel create(@Valid @RequestBody KiteModel kiteLesson){
        return kiteLessonsRepo.create(kiteLesson);
    }

    // Put Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @PutMapping("/{type}")
    public void update(@RequestBody KiteModel kiteLesson, @PathVariable String type){
        kiteLessonsRepo.update(kiteLesson, type);
    }

    // Delete Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @DeleteMapping("/{type}")
    public void delete(@PathVariable String type){
        kiteLessonsRepo.delete(type);
    }

}



