package ismail.myapplication.business.impl;

import ismail.myapplication.dto.KiteLessonDTO;
import ismail.myapplication.repository.entity.KiteLesson;

class KiteLessonConverter {
    public static KiteLessonDTO convertEntityToDTO(KiteLesson kiteLesson) {
        KiteLessonDTO kiteLessonDTO = new KiteLessonDTO();
        kiteLessonDTO.setId(kiteLesson.getId());
        kiteLessonDTO.setType(kiteLesson.getType());
        kiteLessonDTO.setPersons(kiteLesson.getPersons());
        kiteLessonDTO.setHours(kiteLesson.getHours());
        kiteLessonDTO.setPrice(kiteLesson.getPrice());

        return kiteLessonDTO;
    }

    public static KiteLesson convertDTOToEntity(KiteLessonDTO kiteLessonDTO) {
        KiteLesson kiteLesson = new KiteLesson();
        kiteLesson.setId(kiteLessonDTO.getId());
        kiteLesson.setType(kiteLessonDTO.getType());
        kiteLesson.setPersons(kiteLessonDTO.getPersons());
        kiteLesson.setHours(kiteLessonDTO.getHours());
        kiteLesson.setPrice(kiteLessonDTO.getPrice());

        return kiteLesson;
    }
}
