package booking.site.kitelesson.service;

import booking.site.kitelesson.dto.UpdateKiteLessonRequestDTO;
import booking.site.kitelesson.entity.KiteLesson;
import booking.site.kitelesson.repository.KiteLessonRepository;
import booking.site.kitelesson.service.impl.UpdateKiteLessonUseCaseImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateKiteLessonUseCaseImplTest {
    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private UpdateKiteLessonUseCaseImpl updateKiteLessonUseCase;

    @Test
    void shouldUpdateAllKiteLessonFields() {
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
