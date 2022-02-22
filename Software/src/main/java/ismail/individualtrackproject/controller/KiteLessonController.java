package ismail.individualtrackproject.controller;

import ismail.individualtrackproject.business.Implementation.KiteLessonBusinessImpl;
import ismail.individualtrackproject.business.Interface.KiteLessonBusiness;
import ismail.individualtrackproject.model.KiteModel;
import ismail.individualtrackproject.dataLayer.Implementation.KiteLessonDataAccessImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/kitelessons")
public class KiteLessonController {

    //private final KiteLessonBusiness _kiteLessonBusiness;
    private final KiteLessonBusiness _kiteLessonBusiness;

    public KiteLessonController(){
        _kiteLessonBusiness = new KiteLessonBusinessImpl(new KiteLessonDataAccessImpl());
    }

    // Get Request: https://localhost:8080/kitelessons
    @GetMapping
    public List<KiteModel> findAll(){
        return _kiteLessonBusiness.findAll();
    }

    // Get Request: https://localhost:8080/kitelessons/lessontype
    @GetMapping("/{type}")
    public KiteModel findByType(@PathVariable String type){
        return _kiteLessonBusiness.findByType(type);
    }

    // Post Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.CREATED) //201 status code
    @PostMapping
    public KiteModel create(@Valid @RequestBody KiteModel kiteLesson){
        return _kiteLessonBusiness.create(kiteLesson);
    }

    // Put Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @PutMapping("/{type}")
    public void update(@RequestBody KiteModel kiteLesson, @PathVariable String type){
        _kiteLessonBusiness.update(kiteLesson, type);
    }

    // Delete Request: https://localhost:8080/kitelessons
    @ResponseStatus(HttpStatus.NO_CONTENT) //201 status code
    @DeleteMapping("/{type}")
    public void delete(@PathVariable String type){
        _kiteLessonBusiness.delete(type);
    }

}



