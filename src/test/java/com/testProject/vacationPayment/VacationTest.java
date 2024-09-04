package com.testProject.vacationPayment;

import com.testProject.vacationPayment.Models.Vacation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VacationTest {
    Date date;
    Vacation.VacationBuilder vacationBuilder;
    @BeforeEach
    void setUp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.SEPTEMBER, 4);
        date = calendar.getTime();
        vacationBuilder =  new Vacation.VacationBuilder(50000, 7);
    }

    @Test
    void calculate() {
        Vacation vacation = vacationBuilder.build();
        assertEquals(11945.39,vacation.Calculate());
        vacation = vacationBuilder.setStart(date).build();
        assertEquals(8532.42,vacation.Calculate());
    }
}