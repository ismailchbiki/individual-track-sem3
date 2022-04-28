package ismail.myapplication.service.kiteLesson.impl;

import ismail.myapplication.dto.kiteLesson.KiteLessonDTO;
import ismail.myapplication.repository.entity.kiteLesson.KiteLesson;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j /*log the output to the console*/
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