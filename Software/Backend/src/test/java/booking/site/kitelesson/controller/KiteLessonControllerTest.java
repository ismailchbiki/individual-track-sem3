package booking.site.kitelesson.controller;

import booking.site.kitelesson.dto.CreateKiteLessonRequestDTO;
import booking.site.kitelesson.dto.CreateKiteLessonResponseDTO;
import booking.site.kitelesson.dto.GetAllKiteLessonsResponseDTO;
import booking.site.kitelesson.dto.KiteLessonDTO;
import booking.site.kitelesson.service.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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
    private GetKiteLessonUseCase getKiteLessonUseCase;
    @MockBean
    private GetAllKiteLessonsUseCase getAllKiteLessonsUseCase;
    @MockBean
    private DeleteKiteLessonUseCase deleteKiteLessonUseCase;
    @MockBean
    private CreateKiteLessonUseCase createKiteLessonUseCase;
    @MockBean
    private UpdateKiteLessonUseCase updateKiteLessonUseCase;

    @Test
    void getKiteLesson_shouldReturn200WithKiteLesson_whenKiteLessonFound() throws Exception {
        KiteLessonDTO kiteLessonDTO = KiteLessonDTO.builder()
                .id(10L)
                .type("prv")
                .persons(2)
                .hours(2D)
                .price(149.99)
                .build();
        when(getKiteLessonUseCase.getKiteLessonById(10L)).thenReturn(kiteLessonDTO);

        mockMvc.perform(get("/kite-lessons/10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {"id":10,"type":"prv","persons":2,"hours": 2,"price": 149.99}
                        """));

        verify(getKiteLessonUseCase).getKiteLessonById(10L);
    }

    @Test
    void getKiteLesson_shouldReturn404Error_whenKiteLessonNotFound() throws Exception {

        KiteLessonDTO kiteLessonDTO = KiteLessonDTO.builder().build();
        when(getKiteLessonUseCase.getKiteLessonById(10L)).thenReturn(kiteLessonDTO);

        mockMvc.perform(get("/kite-lessons/10"))
                .andDo(print())
                .andExpect(status().isNotFound());

        verify(getKiteLessonUseCase).getKiteLessonById(10L);
    }

    @Test
    void getAllKiteLessons_shouldReturn200WithAllKiteLessonsList_WhenNoFilterProvided() throws Exception {
        GetAllKiteLessonsResponseDTO responseDTO = GetAllKiteLessonsResponseDTO.builder()
                .kiteLessons(List.of(
                        KiteLessonDTO.builder().id(1L).type("prv").persons(1).hours(2D).price(149.99).build(),
                        KiteLessonDTO.builder().id(2L).type("semi-prv").persons(2).hours(2D).price(129.99).build()
                ))
                .build();

        when(getAllKiteLessonsUseCase.getKiteLessons()).thenReturn(responseDTO);

        mockMvc.perform(get("/kite-lessons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {
                                "kiteLessons":[
                                    {"id":1,"type":"prv","persons":1,"hours": 2,"price": 149.99},
                                    {"id":2,"type":"semi-prv","persons":2,"hours": 2,"price": 129.99}
                                ]
                            }
                        """));

        verify(getAllKiteLessonsUseCase).getKiteLessons();
    }

    @Test
    void deleteKiteLesson_shouldReturn204() throws Exception {
        mockMvc.perform(delete("/kite-lessons/20"))
                .andDo(print())
                .andExpect(status().isNoContent());

        verify(deleteKiteLessonUseCase).deleteKiteLesson(20L);
    }

    @Test
    void createKiteLesson_shouldReturn201_whenRequestIsValid() throws Exception {
        CreateKiteLessonRequestDTO expectedRequest = CreateKiteLessonRequestDTO.builder()
                .type("prv")
                .persons(1)
                .hours(2D)
                .price(149.99)
                .build();
        when(createKiteLessonUseCase.createKiteLesson(expectedRequest))
                .thenReturn(CreateKiteLessonResponseDTO.builder()
                        .kiteLessonId(30L)
                        .build());

        mockMvc.perform(post("/kite-lessons")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                    "type": "prv",
                                    "hours": "2",
                                    "persons": "1",
                                    "price": "149.99"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "kiteLessonId":  30 }
                        """));

        verify(createKiteLessonUseCase).createKiteLesson(expectedRequest);
    }

    @Test
    void updateKiteLesson_shouldReturn204() throws Exception {
        mockMvc.perform(put("/kite-lessons/44")
                        .contentType(APPLICATION_JSON_VALUE)
                        .content("""
                                {
                                    "type": "prv",
                                    "hours": "2",
                                    "persons": "1",
                                    "price": "149.99"
                                }
                                """))
                .andDo(print())
                .andExpect(status().isNoContent());

        CreateKiteLessonRequestDTO expectedRequest = CreateKiteLessonRequestDTO.builder()
                .id(44L)
                .type("prv")
                .persons(1)
                .hours(2D)
                .price(149.99)
                .build();
        verify(updateKiteLessonUseCase).updateKiteLesson(expectedRequest);
    }
}

