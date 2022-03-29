package ismail.myapplication.controller;

import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/kitelessons")
@AllArgsConstructor
public class KiteLessonController {
    private KiteLessonRepository kiteLessonRepository;

    @GetMapping
    public List<KiteLesson> findAll(){
        return kiteLessonRepository.findAll();
    }

    //Get Kite Lesson by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<KiteLesson> findKiteLessonById(@PathVariable long id){
        KiteLesson kiteLesson = kiteLessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kite Lesson is not found with Id: " + id));

        return ResponseEntity.ok(kiteLesson);
    }

    //Get Kite Lesson by type
    @GetMapping("/type/{type}")
    public ResponseEntity<KiteLesson> findKiteLessonByType(@PathVariable String type){
        for (KiteLesson kiteLesson : kiteLessonRepository.findAll()) {
            if (kiteLesson.getType().equals(type)) {
                return ResponseEntity.ok().body(kiteLesson);
            }
        }
        return ResponseEntity.notFound().build();
    }

    //create kite lesson
    @PostMapping
    public KiteLesson createKiteLesson(@RequestBody /* -> converts json to java object*/ KiteLesson kiteLesson){
        return kiteLessonRepository.save(kiteLesson);
    }

    //update kite lesson
    @PutMapping("/{id}")
    public ResponseEntity<KiteLesson> updateKiteLesson(@PathVariable long id, @RequestBody KiteLesson kiteLesson){
        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No kite lesson with this id:" + id + " is found."));

        existingKiteLesson.setType(kiteLesson.getType());
        existingKiteLesson.setHours(kiteLesson.getHours());
        existingKiteLesson.setPersons(kiteLesson.getPersons());
        existingKiteLesson.setPrice(kiteLesson.getPrice());

        kiteLessonRepository.save(existingKiteLesson);
        return ResponseEntity.ok(existingKiteLesson);
    }

    //delete kite lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteKiteLesson(@PathVariable long id){
        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kite lesson with this id:" + id + " doesn't exist."));
        kiteLessonRepository.delete(existingKiteLesson);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



