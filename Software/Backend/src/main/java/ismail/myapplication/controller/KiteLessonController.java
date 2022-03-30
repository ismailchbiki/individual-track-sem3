package ismail.myapplication.controller;

import ismail.myapplication.business.GetKiteLessonUseCase;
import ismail.myapplication.business.GetKiteLessonsUseCase;
import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.dto.GetKiteLessonsResponseDTO;
import ismail.myapplication.dto.KiteLessonDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/kite-lessons")
@AllArgsConstructor
public class KiteLessonController {
    private final KiteLessonBusiness kiteLessonBusiness;
    private final GetKiteLessonsUseCase getKiteLessonsUseCase;
    private final GetKiteLessonUseCase getKiteLessonUseCase;

    @GetMapping
    public ResponseEntity<GetKiteLessonsResponseDTO> getAllKiteLessons(){
        return ResponseEntity.ok(getKiteLessonsUseCase.GetKiteLessons());
    }

    //Get Kite Lesson by ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<KiteLessonDTO> getKiteLessonById(@PathVariable long id){
        KiteLessonDTO kiteLessonDTO = getKiteLessonUseCase.getKiteLessonById(id);

        return ResponseEntity.ok(kiteLessonDTO);
    }

    //Get Kite Lesson by type
    @GetMapping("/type/{type}")
    public ResponseEntity<KiteLessonDTO> getKiteLessonByType(@PathVariable String type){

        KiteLessonDTO kiteLessonDTO = getKiteLessonUseCase.getKiteLessonByType(type);
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
        KiteLessonDTO existingKiteLesson = getKiteLessonUseCase.getKiteLessonById(id);
        kiteLessonBusiness.deleteKiteLesson(existingKiteLesson.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

