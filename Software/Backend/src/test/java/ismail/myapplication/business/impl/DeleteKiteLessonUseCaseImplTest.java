package ismail.myapplication.business.impl;

import ismail.myapplication.repository.KiteLessonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
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