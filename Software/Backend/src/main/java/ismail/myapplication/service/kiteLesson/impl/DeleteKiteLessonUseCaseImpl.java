package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.service.kiteLesson.DeleteKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j /*log the output to the console*/
public class DeleteKiteLessonUseCaseImpl implements DeleteKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public void deleteKiteLesson(long id) {

//        KiteLesson existingKiteLesson = kiteLessonRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Kite lesson with this id:" + id + " doesn't exist."));
//        kiteLessonRepository.delete(existingKiteLesson);

        this.kiteLessonRepository.deleteById(id);
    }
}
