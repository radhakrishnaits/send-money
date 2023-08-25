package com.altimetrik.wu.sendmoney.controller;

import com.altimetrik.wu.sendmoney.dto.request.BeneficiaryDTO;
import com.altimetrik.wu.sendmoney.entity.Beneficiary;
import com.altimetrik.wu.sendmoney.service.impl.BeneficiaryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CurrencyController.class)
@SpringBootTest
public class BeneficiaryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BeneficiaryServiceImpl beneficiaryService;

    @InjectMocks
    private BeneficiaryController beneficiaryController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(beneficiaryController).build();
    }

    @Test
    public void getBeneficiariesTest() throws Exception {

        List<Beneficiary> beneficiaryList = getBeneficiaryList();
        when(beneficiaryService.getBeneficiaries(1L)).thenReturn(beneficiaryList);
        this.mockMvc.perform(get("/beneficiary/list/1").
                content(beneficiaryList.toString()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void addBeneficiaryTest() throws Exception {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setSenderID(1L);
        beneficiary.setFirstName("Satyaban");
        beneficiary.setLastName("Rath");
        beneficiary.setAccountNumber("123456789");
        beneficiary.setIfscCode("HDFC0007956");
        beneficiary.setStatus("ACTIVE");
        beneficiary.setCountry("India");

        when(beneficiaryService.addBeneficiary(Mockito.any(BeneficiaryDTO.class))).thenReturn(beneficiary);
        mockMvc.perform(post("/beneficiary/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(beneficiary)))
                .andExpect(status().isOk());
    }

    private static List<Beneficiary> getBeneficiaryList() {

        List<Beneficiary> beneficiaryList = new ArrayList<>();
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setSenderID(1L);
        beneficiary.setFirstName("Satyaban");
        beneficiary.setLastName("Rath");
        beneficiary.setAccountNumber("123456789");
        beneficiary.setIfscCode("HDFC0007956");
        beneficiary.setStatus("ACTIVE");
        beneficiary.setCountry("India");
        beneficiaryList.add(beneficiary);
        return beneficiaryList;
    }
}
