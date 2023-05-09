package com.example.vacationPayCalculator.service.Implements;

import com.example.vacationPayCalculator.service.DaysCalcService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DaysCalcServiceImpl implements DaysCalcService {
    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    private static final List<LocalDate> HOLIDAYS = Stream.of(
            LocalDate.of(CURRENT_YEAR, 1, 1),
            LocalDate.of(CURRENT_YEAR, 1, 2),
            LocalDate.of(CURRENT_YEAR, 1, 3),
            LocalDate.of(CURRENT_YEAR, 1, 4),
            LocalDate.of(CURRENT_YEAR, 1, 5),
            LocalDate.of(CURRENT_YEAR, 1, 6),
            LocalDate.of(CURRENT_YEAR, 1, 7),
            LocalDate.of(CURRENT_YEAR, 1, 8),
            LocalDate.of(CURRENT_YEAR, 2, 23),
            LocalDate.of(CURRENT_YEAR, 2, 24),
            LocalDate.of(CURRENT_YEAR, 3, 8),
            LocalDate.of(CURRENT_YEAR, 5, 1),
            LocalDate.of(CURRENT_YEAR, 5, 8),
            LocalDate.of(CURRENT_YEAR, 5, 9),
            LocalDate.of(CURRENT_YEAR, 6, 12),
            LocalDate.of(CURRENT_YEAR, 11, 4),
            LocalDate.of(CURRENT_YEAR, 11, 6)
    ).collect(Collectors.toList());

    @Override
    public int getNumberOfDaysCalc(LocalDate startVacationDate, int vacationDays) {

        List<LocalDate> filteredDates = Stream
                .iterate(startVacationDate, nextVacationDate -> nextVacationDate.plusDays(1))
                .limit(vacationDays).collect(Collectors.toList());

        // Skip weekends
        for (int i = 0; i < filteredDates.size(); i++) {
            if (filteredDates.get(i).getDayOfWeek() == DayOfWeek.SATURDAY
                    || filteredDates.get(i).getDayOfWeek() == DayOfWeek.SUNDAY
                    || HOLIDAYS.contains(filteredDates.get(i)))
            {
                filteredDates.remove(i);
            }
        }

        return filteredDates.size();
    }
}
