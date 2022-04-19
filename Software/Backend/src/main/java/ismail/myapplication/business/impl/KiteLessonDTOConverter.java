package ismail.myapplication.business.impl;

import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KiteLessonDTOConverter {

    public static KiteLessonDTO convertEntityToDTO(KiteLesson kiteLesson) {

        return KiteLessonDTO.builder()
                .id(kiteLesson.getId())
                .hours(kiteLesson.getHours())
                .persons(kiteLesson.getPersons())
                .price(kiteLesson.getPrice())
                .type(kiteLesson.getType()).build();
    }
}