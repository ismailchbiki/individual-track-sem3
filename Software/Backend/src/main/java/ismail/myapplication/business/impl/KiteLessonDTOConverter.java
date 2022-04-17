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

    public static KiteLesson convertDTOToEntity(KiteLessonDTO kiteLessonDTO) {

        return KiteLesson.builder()
                .id(kiteLessonDTO.getId())
                .hours(kiteLessonDTO.getHours())
                .price(kiteLessonDTO.getPrice())
                .type(kiteLessonDTO.getType())
                .persons(kiteLessonDTO.getPersons()).build();
    }
}