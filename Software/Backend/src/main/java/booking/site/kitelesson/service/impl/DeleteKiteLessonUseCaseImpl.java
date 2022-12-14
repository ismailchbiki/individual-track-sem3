package booking.site.kitelesson.service.impl;

import booking.site.kitelesson.repository.KiteLessonRepository;
import booking.site.kitelesson.service.DeleteKiteLessonUseCase;
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
