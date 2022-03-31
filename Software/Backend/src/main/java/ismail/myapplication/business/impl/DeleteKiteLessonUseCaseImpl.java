package ismail.myapplication.business.impl;

import ismail.myapplication.business.DeleteKiteLessonUseCase;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteKiteLessonUseCaseImpl implements DeleteKiteLessonUseCase {

    private KiteLessonRepository kiteLessonRepository;

    @Override
    public void deleteKiteLesson(long id) {
        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kite lesson with this id:" + id + " doesn't exist."));
        kiteLessonRepository.delete(existingKiteLesson);
    }
}
