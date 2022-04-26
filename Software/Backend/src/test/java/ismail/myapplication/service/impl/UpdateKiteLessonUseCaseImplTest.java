package ismail.myapplication.service.impl;

import ismail.myapplication.service.kiteLesson.impl.UpdateKiteLessonUseCaseImpl;
import ismail.myapplication.dto.kiteLesson.UpdateKiteLessonRequestDTO;
import ismail.myapplication.exception.InvalidKiteLessonException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UpdateKiteLessonUseCaseImplTest {
    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private UpdateKiteLessonUseCaseImpl updateKiteLessonUseCase;

    @Test
    void shouldThrowInvalidKiteLessonExceptionWhenKiteLessonIdInvalid() {
        when(kiteLessonRepositoryMock.findById(1L)).thenReturn(Optional.empty());

        UpdateKiteLessonRequestDTO request = UpdateKiteLessonRequestDTO.builder().id(1L).build();
        InvalidKiteLessonException invalidKiteLessonException = assertThrows(InvalidKiteLessonException.class,
                () -> updateKiteLessonUseCase.updateKiteLesson(request));

        assertEquals("KITE_LESSON_ID_INVALID", invalidKiteLessonException.getReason());
        verify(kiteLessonRepositoryMock).findById(1L);
        verifyNoMoreInteractions(kiteLessonRepositoryMock);
    }


    @Test
    void shouldUpdateAllStudentFields() {
        KiteLesson kiteLessonBeforeUpdate = KiteLesson.builder()
                .id(1L)
                .type("prv")
                .persons(1)
                .hours(2D)
                .price(149.99)
                .build();
        when(kiteLessonRepositoryMock.findById(1L)).thenReturn(Optional.of(kiteLessonBeforeUpdate));

        UpdateKiteLessonRequestDTO request = UpdateKiteLessonRequestDTO.builder()
                .id(1L)
                .type("semi-prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        updateKiteLessonUseCase.updateKiteLesson(request);

        verify(kiteLessonRepositoryMock).findById(1L);
        KiteLesson expectedSavedKiteLesson = KiteLesson.builder()
                .id(1L)
                .type("semi-prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        verify(kiteLessonRepositoryMock).save(expectedSavedKiteLesson);
    }
}
