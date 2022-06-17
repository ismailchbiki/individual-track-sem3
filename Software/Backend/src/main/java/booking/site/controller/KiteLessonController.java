package booking.site.controller;

import booking.site.dto.kite_lesson.*;
import booking.site.service.kite_lesson.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/kite-lessons")
@RequiredArgsConstructor
public class KiteLessonController {

    private final CreateKiteLessonUseCase createKiteLessonUseCase;
    private final UpdateKiteLessonUseCase updateKiteLessonUseCase;
    private final DeleteKiteLessonUseCase deleteKiteLessonUseCase;
    private final GetKiteLessonUseCase getKiteLessonUseCase;
    private final GetAllKiteLessonsUseCase getAllKiteLessonsUseCase;

    @GetMapping
    public ResponseEntity<GetAllKiteLessonsResponseDTO> getAllKiteLessons() {
        return ResponseEntity.ok().body(getAllKiteLessonsUseCase.getKiteLessons());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<KiteLessonDTO> getKiteLessonById(@PathVariable long id) {
        KiteLessonDTO kiteLessonDTO = getKiteLessonUseCase.getKiteLessonById(id);

        if (!ObjectUtils.isEmpty(kiteLessonDTO)) {
            return ResponseEntity.ok().body(kiteLessonDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<KiteLessonDTO> getKiteLessonByType(@PathVariable String type) {

        KiteLessonDTO kiteLessonDTO = getKiteLessonUseCase.getKiteLessonByType(type);
        if (kiteLessonDTO == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(kiteLessonDTO);
    }

    @PostMapping
    public ResponseEntity<CreateKiteLessonResponseDTO> createKiteLesson(@RequestBody /* -> converts json to java object*/ CreateKiteLessonRequestDTO createRequestDTO) {
        CreateKiteLessonResponseDTO response = createKiteLessonUseCase.createKiteLesson(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KiteLessonDTO> updateKiteLesson(@PathVariable("id") long id, @RequestBody UpdateKiteLessonRequestDTO request) {

        request.setId(id);
        updateKiteLessonUseCase.updateKiteLesson(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKiteLesson(@PathVariable long id) {
        deleteKiteLessonUseCase.deleteKiteLesson(id);
        return ResponseEntity.noContent().build();
    }
}

