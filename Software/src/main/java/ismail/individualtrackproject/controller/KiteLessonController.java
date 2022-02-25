package ismail.individualtrackproject.controller;

import ismail.individualtrackproject.business.Interface.KiteLessonBusiness;
import ismail.individualtrackproject.model.KiteModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/kitelessons")
public class KiteLessonController {

    private KiteLessonBusiness kiteLessonBusiness;

    // Get Request: https://localhost:8080/kitelessons
    @GetMapping
    public List<KiteModel> findAll(){
        return kiteLessonBusiness.findAll();
    }

    // Get Request: https://localhost:8080/kitelessons/lessontype
    @GetMapping("/{type}")
    public KiteModel findByType(@PathVariable String type){
        return kiteLessonBusiness.findByType(type);
    }

    // Post Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.CREATED) //201 status code
    @PostMapping
    public KiteModel create(@Valid @RequestBody KiteModel kiteLesson){
        return kiteLessonBusiness.create(kiteLesson);
    }

    // Put Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @PutMapping("/{type}")
    public void update(@RequestBody KiteModel kiteLesson, @PathVariable String type){
        kiteLessonBusiness.update(kiteLesson, type);
    }

    // Delete Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @DeleteMapping("/{type}")
    public void delete(@PathVariable String type){
        kiteLessonBusiness.delete(type);
    }

}



