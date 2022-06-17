package bookingSite.service.kiteLesson.impl;

import bookingSite.dto.kiteLesson.KiteLessonDTO;
import bookingSite.repository.entity.kiteLesson.KiteLesson;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Slf4j
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