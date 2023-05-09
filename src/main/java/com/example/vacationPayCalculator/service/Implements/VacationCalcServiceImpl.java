package com.example.vacationPayCalculator.service.Implements;

import com.example.vacationPayCalculator.model.VacationPayDTO;
import com.example.vacationPayCalculator.service.VacationCalcService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class VacationCalcServiceImpl implements VacationCalcService {

    private static final double AVERAGE_DAYS_NUMBER_PER_MONTH = 29.3;
    private static final double PIT_PERCENTAGE = 0.13;

    @Override
    public VacationPayDTO getVacationPayCalc(BigDecimal averageSalaryPerYear, int vacationDays) {
        double workingDays = 12 * AVERAGE_DAYS_NUMBER_PER_MONTH; // Estimated number of days

        BigDecimal salaryPerDay = averageSalaryPerYear.divide(BigDecimal.valueOf(workingDays), 2, RoundingMode.HALF_EVEN);

        BigDecimal vacationPay = salaryPerDay.multiply(BigDecimal.valueOf(vacationDays)); // Pay without PIT

        vacationPay = vacationPay.subtract(vacationPay.multiply(BigDecimal.valueOf(PIT_PERCENTAGE))); // Calculate with PIT

        return new VacationPayDTO("Сумма отпускных с вычетом НДФЛ: ", vacationPay);
    }
}
