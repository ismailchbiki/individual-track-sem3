package booking.site.service.impl;

import booking.site.repository.KiteLessonRepository;
import booking.site.service.kite_lesson.impl.DeleteKiteLessonUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteKiteLessonUseCaseImplTest {

    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private DeleteKiteLessonUseCaseImpl deleteKiteLessonUseCase;

    @Test
    void shouldDeleteStudent() {
        deleteKiteLessonUseCase.deleteKiteLesson(10L);

        verify(kiteLessonRepositoryMock).deleteById(10L);
    }
}