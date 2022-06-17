package bookingSite.service.kiteLesson.impl;

import bookingSite.repository.KiteLessonRepository;
import bookingSite.service.kiteLesson.DeleteKiteLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteKiteLessonUseCaseImpl implements DeleteKiteLessonUseCase {

    private final KiteLessonRepository kiteLessonRepository;

    @Override
    public void deleteKiteLesson(long id) {
        kiteLessonRepository.deleteById(id);
    }
}
