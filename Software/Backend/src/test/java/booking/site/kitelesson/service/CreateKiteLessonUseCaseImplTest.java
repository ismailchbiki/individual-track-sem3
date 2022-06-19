package booking.site.kitelesson.service;

import booking.site.exception.KiteLessonTypeAlreadyExistsException;
import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;
import booking.site.kitelesson.dto.CreateKiteLessonResponseDTO;
import booking.site.kitelesson.entity.KiteLesson;
import booking.site.kitelesson.repository.KiteLessonRepository;
import booking.site.kitelesson.service.impl.CreateKiteLessonUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateKiteLessonUseCaseImplTest {

    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private CreateKiteLessonUseCaseImpl createKiteLessonUseCaseImpl;

    @Test
    void shouldThrowTypeAlreadyExistsExceptionWhenItAlreadyExists() {
        when(kiteLessonRepositoryMock.existsByType("prv")).thenReturn(true);
        CreateKiteLessonRequestDTO request = CreateKiteLessonRequestDTO.builder()
                .type("prv")
                .build();
        assertThrows(KiteLessonTypeAlreadyExistsException.class, () -> createKiteLessonUseCaseImpl.createKiteLesson(request));
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
                .hours(2D)
                .persons(2)
                .price(99.99)
                .build();

        CreateKiteLessonResponseDTO actualResponse = createKiteLessonUseCaseImpl.createKiteLesson(request);

        CreateKiteLessonResponseDTO expectedResponse = CreateKiteLessonResponseDTO.builder()
                .kiteLessonId(255L)
                .build();
        assertEquals(expectedResponse, actualResponse);
        verify(kiteLessonRepositoryMock).existsByType("prv");
        verify(kiteLessonRepositoryMock).save(expectedKiteLessonToSave);
    }
}