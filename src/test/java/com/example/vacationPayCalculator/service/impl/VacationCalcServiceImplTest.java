package com.example.vacationPayCalculator.service.impl;

import com.example.vacationPayCalculator.model.VacationPayDTO;
import com.example.vacationPayCalculator.service.Implements.VacationCalcServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class VacationCalcServiceImplTest {
    @InjectMocks
    private VacationCalcServiceImpl calcService;
    @Test
    public void shouldGetVacationPay() {
        VacationPayDTO result = calcService.getVacationPayCalc(BigDecimal.valueOf(141000), 14);
        BigDecimal expectedResult = BigDecimal.valueOf(4884.4236);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result.getVacationPay());
    }
}
