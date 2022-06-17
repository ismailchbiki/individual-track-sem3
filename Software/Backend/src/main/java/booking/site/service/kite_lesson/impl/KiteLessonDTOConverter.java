package booking.site.service.kite_lesson.impl;

import booking.site.dto.kite_lesson.KiteLessonDTO;
import booking.site.repository.entity.kite_lesson.KiteLesson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KiteLessonDTOConverter {

    private KiteLessonDTOConverter() {
    }

    public static KiteLessonDTO convertEntityToDTO(KiteLesson kiteLesson) {

        return KiteLessonDTO.builder()
                .id(kiteLesson.getId())
                .hours(kiteLesson.getHours())
                .persons(kiteLesson.getPersons())
                .price(kiteLesson.getPrice())
                .type(kiteLesson.getType()).build();
    }
}