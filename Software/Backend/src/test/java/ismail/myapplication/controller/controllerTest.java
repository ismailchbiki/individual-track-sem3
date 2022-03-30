/*
package ismail.myapplication.controller;

import ismail.myapplication.AbstractContainerBaseTest;
import ismail.myapplication.business.KiteLessonBusiness;
import ismail.myapplication.repository.KiteLessonRepository;
import ismail.myapplication.repository.entity.KiteLesson;
import lombok.AllArgsConstructor;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@AllArgsConstructor
@SpringBootTest
@AutoConfigureMockMvc
public class controllerTest extends AbstractContainerBaseTest {

    */
/*@Autowired
    private KiteLessonRepository kiteLessonRepository;*//*

    @Autowired
    private MockMvc mockMvc;

    private KiteLessonBusiness kiteLessonBusiness;

    @Test
    public void findAllKiteLessons_ListShouldMatch() throws Exception {

        //Arrange
        List<KiteLesson> kiteLessons = List.of(KiteLesson.builder()
                        .id(1L)
                        .price(150.0)
                        .type("private")
                        .hours(2.0)
                        .persons(1)
                        .build(),
                KiteLesson.builder()
                        .id(2L)
                        .price(100.0)
                        .type("semi-private")
                        .hours(2.0)
                        .persons(2).build());
        //kiteLessonRepository.saveAll(kiteLessons);

        //Act
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/kite-lessons"));

        //Assert
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(kiteLessons.size())));
    }
}
*/
