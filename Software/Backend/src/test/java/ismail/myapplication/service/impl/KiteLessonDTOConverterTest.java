package ismail.myapplication.service.impl;

import ismail.myapplication.service.kiteLesson.impl.KiteLessonDTOConverter;
import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
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