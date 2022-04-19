package ismail.myapplication.business.impl;

import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetKiteLessonUseCaseImplTest {

    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private GetKiteLessonUseCaseImpl getKiteLessonUseCase;

    @Test
    void shouldReturnKiteLessonIfFoundById() {
        KiteLesson kiteLesson = KiteLesson.builder()
                .id(50L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        when(kiteLessonRepositoryMock.findById(50L)).thenReturn(Optional.of(kiteLesson));

        KiteLessonDTO actualDTO = getKiteLessonUseCase.getKiteLessonById(50L);

        KiteLessonDTO expectedDTO = KiteLessonDTO.builder()
                .id(50L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        assertEquals(expectedDTO, actualDTO);

        verify(kiteLessonRepositoryMock).findById(50L);
    }

    @Test
    void shouldReturnNullIfKiteLessonNotFoundById() {
        KiteLesson kiteLesson = new KiteLesson();
        when(kiteLessonRepositoryMock.findById(50L)).thenReturn(Optional.of(kiteLesson));

        KiteLessonDTO actualDTO = getKiteLessonUseCase.getKiteLessonById(50L);

        KiteLessonDTO expectedDTO = new KiteLessonDTO();
        assertEquals(expectedDTO, actualDTO);

        verify(kiteLessonRepositoryMock).findById(50L);
    }

    @Test
    void shouldReturnKiteLessonIfFoundByType() {
        KiteLesson kiteLesson = KiteLesson.builder()
                .id(50L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        when(kiteLessonRepositoryMock.findByType("prv")).thenReturn(kiteLesson);

        KiteLessonDTO actualDTO = getKiteLessonUseCase.getKiteLessonByType("prv");

        KiteLessonDTO expectedDTO = KiteLessonDTO.builder()
                .id(50L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();
        assertEquals(expectedDTO, actualDTO);

        verify(kiteLessonRepositoryMock).findByType("prv");
    }

    @Test
    void shouldReturnNullIfNotFoundByType() {
        KiteLesson kiteLesson = new KiteLesson();
        when(kiteLessonRepositoryMock.findByType("prv")).thenReturn(kiteLesson);

        KiteLessonDTO actualDTO = getKiteLessonUseCase.getKiteLessonByType("prv");

        KiteLessonDTO expectedDTO = new KiteLessonDTO();
        assertEquals(expectedDTO, actualDTO);

        verify(kiteLessonRepositoryMock).findByType("prv");
    }
}