package bookingSite.service.impl;

import bookingSite.dto.kiteLesson.KiteLessonDTO;
import bookingSite.repository.entity.kiteLesson.KiteLesson;
import bookingSite.service.kiteLesson.impl.KiteLessonDTOConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KiteLessonDTOConverterTest {

    @Test
    void shouldConvertAllKiteLessonFieldsToDTO() {
        KiteLesson kiteLessonTobeConverted = KiteLesson.builder()
                .id(1L)
                .type("semi-prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();

        KiteLessonDTO actualDTO = KiteLessonDTOConverter.convertEntityToDTO(kiteLessonTobeConverted);

        KiteLessonDTO expectedDTO = KiteLessonDTO.builder()
                .id(1L)
                .type("semi-prive")
                .persons(2)
                .hours(2D)
                .price(99.99)
                .build();

        assertEquals(expectedDTO, actualDTO);
    }
}