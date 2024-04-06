package com.example.CompanyPrices.controller;

import com.example.CompanyPrices.application.service.PricesService;
import com.example.CompanyPrices.entities.Prices;
import com.example.CompanyPrices.infrastructure.controller.PricesController;
import com.example.CompanyPrices.infrastructure.repository.PricesRepository;
import com.example.infrastructure.controller.model.PriceResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static java.lang.StringTemplate.STR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PricesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PricesControllerTest {

    private final EasyRandom generator = new EasyRandom();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService pricesService;
    private static final int PRODUCT_ID = 1;
    private static final int BRAND_ID = 1;
    private static final OffsetDateTime OFFSET_DATE_TIME = LocalDateTime.now().withYear(2024).withMonth(5).withDayOfMonth(1).atOffset(ZoneOffset.UTC);
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Test
    void should_get_price_properly() throws Exception {

        PriceResponseDTO mockedResponse = generator.nextObject(PriceResponseDTO.class);
        given(pricesService.searchPrice(anyInt(), anyInt(), any())).willReturn(mockedResponse);

        MockHttpServletResponse response =
                mockMvc.perform(
                        get(STR."/prices?productId=\{PRODUCT_ID}&brandId=\{BRAND_ID}&applyDate=\{OFFSET_DATE_TIME}")
                )
                .andExpect(status().isOk())
                .andReturn().getResponse();

        PriceResponseDTO responseDTO = mapper.readValue(response.getContentAsString(), PriceResponseDTO.class);
        assertThat(responseDTO).isEqualTo(mockedResponse);
    }

}
