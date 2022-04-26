package ismail.myapplication.service.impl;

import ismail.myapplication.service.kiteLesson.impl.CreateKiteLessonUseCaseImpl;
import ismail.myapplication.dto.kiteLesson.CreateKiteLessonRequestDTO;
import ismail.myapplication.dto.kiteLesson.CreateKiteLessonResponseDTO;
import ismail.myapplication.exception.KiteLessonTypeAlreadyExistsException;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateKiteLessonUseCaseImplTest {

    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private CreateKiteLessonUseCaseImpl createKiteLessonUseCase;

    @Test
    void shouldThrowTypeAlreadyExistsExceptionWhenItAlreadyExists() {

        when(kiteLessonRepositoryMock.existsByType("prv")).thenReturn(true);

        CreateKiteLessonRequestDTO request = CreateKiteLessonRequestDTO.builder()
                .type("prv")
                .build();
        assertThrows(KiteLessonTypeAlreadyExistsException.class, () -> createKiteLessonUseCase.createKiteLesson(request));

        verify(kiteLessonRepositoryMock).existsByType("prv");
    }

    @Test
    void shouldSaveNewKiteLesson() {

        when(kiteLessonRepositoryMock.existsByType("prv")).thenReturn(false);
        KiteLesson expectedKiteLessonToSave = KiteLesson.builder()
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        KiteLesson savedKiteLesson = KiteLesson.builder()
                .id(255L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        when(kiteLessonRepositoryMock.save(expectedKiteLessonToSave)).thenReturn(savedKiteLesson);

        CreateKiteLessonRequestDTO request = CreateKiteLessonRequestDTO.builder()
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();

        CreateKiteLessonResponseDTO actualResponse = createKiteLessonUseCase.createKiteLesson(request);

        CreateKiteLessonResponseDTO expectedResponse = CreateKiteLessonResponseDTO.builder()
                .kiteLessonId(255L)
                .build();
        assertEquals(expectedResponse, actualResponse);
        verify(kiteLessonRepositoryMock).existsByType("prv");
        verify(kiteLessonRepositoryMock).save(expectedKiteLessonToSave);
    }
}