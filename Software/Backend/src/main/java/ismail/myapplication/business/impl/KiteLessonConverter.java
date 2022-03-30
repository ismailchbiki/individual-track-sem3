package ismail.myapplication.business.impl;

import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.entity.KiteLesson;

class KiteLessonConverter {
    private KiteLessonConverter() {
    }

    //Convert Entity to DTO
    public static KiteLessonDTO convertEntityToDTO(KiteLesson kiteLesson) {
        /*KiteLessonDTO kiteLessonDTO = new KiteLessonDTO();
        kiteLessonDTO.setId(kiteLesson.getId());
        kiteLessonDTO.setType(kiteLesson.getType());
        kiteLessonDTO.setPersons(kiteLesson.getPersons());
        kiteLessonDTO.setHours(kiteLesson.getHours());
        kiteLessonDTO.setPrice(kiteLesson.getPrice());*/

        return KiteLessonDTO.builder()
                .id(kiteLesson.getId())
                .hours(kiteLesson.getHours())
                .persons(kiteLesson.getPersons())
                .price(kiteLesson.getPrice())
                .type(kiteLesson.getType()).build();
    }

    //Convert DTO to Entity
    public static KiteLesson convertDTOToEntity(KiteLessonDTO kiteLessonDTO) {
        /*KiteLesson kiteLesson = new KiteLesson();
        kiteLesson.setId(kiteLessonDTO.getId());
        kiteLesson.setType(kiteLessonDTO.getType());
        kiteLesson.setPersons(kiteLessonDTO.getPersons());
        kiteLesson.setHours(kiteLessonDTO.getHours());
        kiteLesson.setPrice(kiteLessonDTO.getPrice());*/

        return KiteLesson.builder()
                .id(kiteLessonDTO.getId())
                .hours(kiteLessonDTO.getHours())
                .price(kiteLessonDTO.getPrice())
                .type(kiteLessonDTO.getType())
                .persons(kiteLessonDTO.getPersons()).build();
    }
}
