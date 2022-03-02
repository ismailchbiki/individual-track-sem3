package ismail.myapplication.controller;

import ismail.myapplication.service.KiteLessonService;
import ismail.myapplication.model.KiteModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/kitelessons")
public class KiteLessonController {

    private KiteLessonService kiteLessonService;

    // Get Request: https://localhost:8080/kitelessons
    @GetMapping
    public List<KiteModel> findAll(){
        return kiteLessonService.findAll();
    }

    // Get Request: https://localhost:8080/kitelessons/lessontype
    @GetMapping("/{type}")
    public KiteModel findByType(@PathVariable String type){
        return kiteLessonService.findByType(type);
    }

    // Post Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.CREATED) //201 status code
    @PostMapping
    public KiteModel create(@Valid @RequestBody KiteModel kiteLesson){
        return kiteLessonService.create(kiteLesson);
    }

    // Put Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @PutMapping("/{type}")
    public void update(@RequestBody KiteModel kiteLesson, @PathVariable String type){
        kiteLessonService.update(kiteLesson, type);
    }

    // Delete Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @DeleteMapping("/{type}")
    public void delete(@PathVariable String type){
        kiteLessonService.delete(type);
    }

}



