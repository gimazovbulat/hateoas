package ru.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.models.Resident;
import ru.itis.services.HotelService;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TrashController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class TrashControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HotelService hotelService;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        when(hotelService.bookWholeFloor(notSavedResident())).thenReturn(savedResident());
    }

    @Test
    public void coursePublishTest() throws Exception {
        mockMvc.perform(post("/residents/wholeFloor")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(notSavedResident())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(savedResident().getName()))
                .andExpect(jsonPath("$.age").value(savedResident().getAge()))
                .andExpect(jsonPath("$.wholeFloor").value(savedResident().getWholeFloor()))
                .andExpect(jsonPath("$.isVip").value(savedResident().getIsVip()))
                .andExpect(jsonPath("$.id").value(savedResident().getId()))
                .andDo(document("book_whole_floor", responseFields(
                        fieldWithPath("name").description("Имя резидента"),
                        fieldWithPath("age").description("Возраст резидента"),
                        fieldWithPath("wholeFloor").description("Заказн весь этаж"),
                        fieldWithPath("isVip").description("Вип иль нет"),
                        fieldWithPath("id").ignored()
                )));
    }

    private Resident savedResident() {
        return Resident.builder()
                .id(1L)
                .age(12)
                .isVip(true)
                .name("fdgf")
                .wholeFloor(true)
                .build();
    }

    private Resident notSavedResident() {
        return Resident.builder()
                .id(1L)
                .age(12)
                .isVip(true)
                .name("fdgf")
                .build();
    }
}
