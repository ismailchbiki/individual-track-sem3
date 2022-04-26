package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
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