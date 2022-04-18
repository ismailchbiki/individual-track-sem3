package ismail.myapplication.controller;

import ismail.myapplication.business.*;
import ismail.myapplication.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/kite-lessons")
@RequiredArgsConstructor
public class KiteLessonController {

    private final CreateKiteLessonUseCase createKiteLessonUseCase;
    private final UpdateKiteLessonUseCase updateKiteLessonUseCase;
    private final DeleteKiteLessonUseCase deleteKiteLessonUseCase;
    private final GetKiteLessonUseCase getKiteLessonUseCase;
    private final GetAllKiteLessonsUseCase getAllKiteLessonsUseCase;

    @GetMapping
    public ResponseEntity<GetAllKiteLessonsResponseDTO> getAllKiteLessons(){
        return new ResponseEntity(getAllKiteLessonsUseCase.getKiteLessons(), HttpStatus.OK);
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
    public ResponseEntity<CreateKiteLessonResponseDTO> createKiteLesson(@RequestBody /* -> converts json to java object*/ CreateKiteLessonRequestDTO createRequestDTO){
        CreateKiteLessonResponseDTO response = createKiteLessonUseCase.createKiteLesson(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //update kite lesson
    @PutMapping("/{id}")
    public ResponseEntity<KiteLessonDTO> updateKiteLesson(@PathVariable("id") long id, @RequestBody UpdateKiteLessonRequestDTO request){

        request.setId(id);
        updateKiteLessonUseCase.updateKiteLesson(request);
        return ResponseEntity.noContent().build();
    }

    //delete kite lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteKiteLesson(@PathVariable long id){
        KiteLessonDTO existingKiteLesson = getKiteLessonUseCase.getKiteLessonById(id);
        deleteKiteLessonUseCase.deleteKiteLesson(existingKiteLesson.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

