package com.example.vacationPayCalculator.service.impl;

import com.example.vacationPayCalculator.service.Implements.DaysCalcServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class DaysCalcServiceImplTest {
    @InjectMocks
    private DaysCalcServiceImpl calcService;
    @Test
    public void shouldGetFilteredDays() {
        int result = calcService.getNumberOfDaysCalc(LocalDate.parse("2023-05-01"), 30);
        int expectedResult = 24;

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedResult, result);

    }
}
