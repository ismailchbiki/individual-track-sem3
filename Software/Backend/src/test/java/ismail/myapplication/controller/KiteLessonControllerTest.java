package ismail.myapplication.controller;

import ismail.myapplication.business.*;
import ismail.myapplication.dto.KiteLessonDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(KiteLessonController.class)
class KiteLessonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateKiteLessonUseCase createKiteLessonUseCase;
    @MockBean
    private UpdateKiteLessonUseCase updateKiteLessonUseCase;
    @MockBean
    private DeleteKiteLessonUseCase deleteKiteLessonUseCase;
    @MockBean
    private GetKiteLessonUseCase getKiteLessonUseCase;
    @MockBean
    private GetAllKiteLessonsUseCase getAllKiteLessonsUseCase;

   /* @Test
    void createKiteLesson() throws Exception {
        KiteLessonDTO expectedRequest = KiteLessonDTO.builder()
                .type("test-type")
                .hours(2D)
                .persons(2)
                .price(150D)
                .build();

        when(createKiteLessonUseCase.createKiteLesson(expectedRequest))
                .thenReturn(KiteLessonDTO.builder()
                        .id(25L)
                        .type("test-type")
                        .hours(2D)
                        .persons(2)
                        .price(150D)
                        .build());

        mockMvc.perform(post("/api/v1/kite-lessons")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                    "type": "test-type",
                                    "hours": 2,
                                    "persons": 2,
                                    "price": 150
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "studentId":  25 }
                        """));

        verify(createKiteLessonUseCase).createKiteLesson(expectedRequest);
    }*/

    @Test
    void getKiteLesson_shouldReturn200WithKiteLesson_whenKiteLessonFound() throws Exception {
        KiteLessonDTO kiteLessonDTO = KiteLessonDTO.builder()
                .id(17L)
                .type("test-type")
                .persons(2)
                .hours(2D)
                .price(200D)
                .build();

        when(getKiteLessonUseCase.getKiteLessonById(17L)).thenReturn(kiteLessonDTO);

        mockMvc.perform(get("/api/v1/kite-lessons/17"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {"id":17, "type":"test-type", "persons":2, "hours":2, "price":200}
                        """));

        verify(getKiteLessonUseCase).getKiteLessonById(17L);
    }

    @Test
    void getKiteLesson_shouldReturn200Success_whenKiteLessonFound() throws Exception {
        /*when(getKiteLessonUseCase.getKiteLessonById(155L)).thenReturn(null);*/

        mockMvc.perform(get("/api/v1/kite-lessons/1555"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(getKiteLessonUseCase).getKiteLessonById(1555L);
    }
}

