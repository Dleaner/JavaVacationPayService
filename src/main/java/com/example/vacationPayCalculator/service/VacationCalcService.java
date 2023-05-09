package com.example.vacationPayCalculator.service;

import com.example.vacationPayCalculator.model.VacationPayDTO;

import java.math.BigDecimal;

public interface VacationCalcService {
    VacationPayDTO getVacationPayCalc(BigDecimal averageSalaryPerYear, int vacationDays);
}
