package booking.site.service.impl;

import booking.site.dto.kite_lesson.KiteLessonDTO;
import booking.site.repository.entity.kite_lesson.KiteLesson;
import booking.site.service.kite_lesson.impl.KiteLessonDTOConverter;
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