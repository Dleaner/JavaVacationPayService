package com.example.vacationPayCalculator.service;

import java.time.LocalDate;

public interface DaysCalcService {
    int getNumberOfDaysCalc(LocalDate startVacationDate, int vacationDays);
}
