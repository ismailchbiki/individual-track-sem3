package ismail.myapplication.controller;

import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.dto.KiteLesson;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/kitelessons")
public class KiteLessonController {

    private KiteLessonBusiness kiteLessonBusiness;

    public KiteLessonController(KiteLessonBusiness kiteLessonBusiness) {
        this.kiteLessonBusiness = kiteLessonBusiness;
    }

    // Get Request: https://localhost:8080/kitelessons
    @GetMapping
    public List<KiteLesson> findAll(){
        return kiteLessonBusiness.findAll();
    }

    // Get Request: https://localhost:8080/kitelessons/lessontype
    @GetMapping("/{type}")
    public KiteLesson findByType(@PathVariable String type){
        return kiteLessonBusiness.findByType(type);
    }

    // Post Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.CREATED) //201 status code
    @PostMapping
    public KiteLesson create(@Valid @RequestBody KiteLesson kiteLesson){
        return kiteLessonBusiness.create(kiteLesson);
    }

    // Put Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @PutMapping("/{type}")
    public void update(@RequestBody KiteLesson kiteLesson, @PathVariable String type){
        kiteLessonBusiness.update(kiteLesson, type);
    }

    // Delete Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @DeleteMapping("/{type}")
    public void delete(@PathVariable String type){
        kiteLessonBusiness.delete(type);
    }

}



