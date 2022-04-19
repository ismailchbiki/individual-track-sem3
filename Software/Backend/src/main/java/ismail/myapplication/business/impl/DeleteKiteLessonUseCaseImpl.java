package ismail.myapplication.business.impl;

import ismail.myapplication.business.DeleteKiteLessonUseCase;
import ismail.myapplication.exception.ResourceNotFoundException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteKiteLessonUseCaseImpl implements DeleteKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    @Transactional
    public void deleteKiteLesson(long id) {

//        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Kite lesson with this id:" + id + " doesn't exist."));
//        kiteLessonRepository.delete(existingKiteLesson);

        this.kiteLessonRepository.deleteById(id);
    }
}
