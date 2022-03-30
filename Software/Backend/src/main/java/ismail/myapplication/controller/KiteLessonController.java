package ismail.myapplication.controller;

import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.dto.KiteLessonDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/kite-lessons")
@AllArgsConstructor
public class KiteLessonController {
    private final KiteLessonBusiness kiteLessonBusiness;

    @GetMapping
    public List<KiteLessonDTO> findAll(){
        return kiteLessonBusiness.findAllKiteLessons();
    }

    //Get Kite Lesson by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<KiteLessonDTO> findKiteLessonById(@PathVariable long id){
        KiteLessonDTO kiteLessonDTO = kiteLessonBusiness.findKiteLessonById(id);

        return ResponseEntity.ok(kiteLessonDTO);
    }

    //Get Kite Lesson by type
    @GetMapping("/type/{type}")
    public ResponseEntity<KiteLessonDTO> findKiteLessonByType(@PathVariable String type){

        KiteLessonDTO kiteLessonDTO = kiteLessonBusiness.findKiteLessonByType(type);
        if (kiteLessonDTO == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(kiteLessonDTO);
    }

    //create kite lesson
    @PostMapping
    public KiteLessonDTO createKiteLesson(@RequestBody /* -> converts json to java object*/ KiteLessonDTO kiteLessonDTO){
        return kiteLessonBusiness.createKiteLesson(kiteLessonDTO);
    }

    //update kite lesson
    @PutMapping("/{id}")
    public ResponseEntity<KiteLessonDTO> updateKiteLesson(@PathVariable long id, @RequestBody KiteLessonDTO kiteLessonDTO){

        KiteLessonDTO newKiteLesson = kiteLessonBusiness.updateKiteLesson(id, kiteLessonDTO);
        return ResponseEntity.ok(newKiteLesson);
    }

    //delete kite lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteKiteLesson(@PathVariable long id){
        KiteLessonDTO existingKiteLesson = kiteLessonBusiness.findKiteLessonById(id);
        kiteLessonBusiness.deleteKiteLesson(existingKiteLesson.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

