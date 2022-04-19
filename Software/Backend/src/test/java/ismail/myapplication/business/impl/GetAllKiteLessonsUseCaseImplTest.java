package ismail.myapplication.business.impl;

import ismail.myapplication.dto.GetAllKiteLessonsResponseDTO;
import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllKiteLessonsUseCaseImplTest {

    @Mock
    private KiteLessonRepository kiteLessonRepositoryMock;

    @InjectMocks
    private GetAllKiteLessonsUseCaseImpl getAllKiteLessonsUseCase;

    @Test
    void shouldReturnAllKiteLessons() {
        List<KiteLesson> kiteLessons = List.of(
                KiteLesson.builder().id(1L).type("prv").hours(2D).persons(1).price(100D).build(),
                KiteLesson.builder().id(2L).type("semi-prv").hours(2D).persons(2).price(80D).build());
        when(kiteLessonRepositoryMock.findAll()).thenReturn(kiteLessons);

        GetAllKiteLessonsResponseDTO actualResponse = getAllKiteLessonsUseCase.getKiteLessons();

        GetAllKiteLessonsResponseDTO expectedResponse = GetAllKiteLessonsResponseDTO.builder()
                .kiteLessons(List.of(
                        KiteLessonDTO.builder().id(1L).type("prv").hours(2D).persons(1).price(100D).build(),
                        KiteLessonDTO.builder().id(2L).type("semi-prv").hours(2D).persons(2).price(80D).build()))
                .build();
        assertEquals(expectedResponse, actualResponse);

        verify(kiteLessonRepositoryMock).findAll();
    }
}