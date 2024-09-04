package com.testProject.vacationPayment.Models;

import com.testProject.vacationPayment.Helpers.PaymentCalculator;

import java.util.Date;

public class Vacation {
    double averagePayment;
    int vacationDays;
    Date start;

    public Vacation(VacationBuilder vacationBuilder) {
        averagePayment = vacationBuilder.averagePayment;
        vacationDays = vacationBuilder.vacationDays;
        start = vacationBuilder.start;
    }

    public double Calculate() {
        if (start != null)
            vacationDays = PaymentCalculator.getWorkDays(start, vacationDays);
        return Math.round(averagePayment/29.3*vacationDays * 100.0) / 100.0;
    }

    public static class VacationBuilder {
        double averagePayment;
        int vacationDays;
        Date start;

        public VacationBuilder(double averagePayment, int vacationDays) {
            this.averagePayment = averagePayment;
            this.vacationDays = vacationDays;
        }

        public VacationBuilder setStart(Date start) {
            this.start = start;
            return this;
        }

        public Vacation build() {
            return new Vacation(this);
        }
    }
}
