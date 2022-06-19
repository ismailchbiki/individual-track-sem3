package booking.site.kitelesson.service.impl;

import booking.site.kitelesson.dto.KiteLessonDTO;
import booking.site.kitelesson.entity.KiteLesson;
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