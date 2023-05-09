package com.example.vacationPayCalculator.controller;

import com.example.vacationPayCalculator.model.VacationPayDTO;
import com.example.vacationPayCalculator.service.DaysCalcService;
import com.example.vacationPayCalculator.service.VacationCalcService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class CalculatorController {
    private final VacationCalcService vacationService;
    private final DaysCalcService daysService;

    public CalculatorController(VacationCalcService vacationService, DaysCalcService daysService) {
        this.vacationService = vacationService;
        this.daysService = daysService;
    }

    @GetMapping("/calculate")
    public VacationPayDTO getCustomer(
            @RequestParam(name = "averageSalaryPerYear") BigDecimal averageSalaryPerYear,
            @RequestParam(name = "vacationDays") int vacationDays,
            @RequestParam(name = "beginVacationDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginVacationDate) {
        if (beginVacationDate != null) {
            vacationDays = daysService.getNumberOfDaysCalc(beginVacationDate, vacationDays);
        }
        return vacationService.getVacationPayCalc(averageSalaryPerYear, vacationDays);
    }
}
