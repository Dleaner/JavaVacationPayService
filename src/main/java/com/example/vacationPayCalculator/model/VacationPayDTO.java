package com.example.vacationPayCalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class VacationPayDTO {
    private String message;
    private BigDecimal vacationPay;

    public BigDecimal getVacationPay() {
        return vacationPay;
    }

}
