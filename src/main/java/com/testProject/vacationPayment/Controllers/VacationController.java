package com.testProject.vacationPayment.Controllers;

import com.testProject.vacationPayment.Models.Vacation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class VacationController {

    @GetMapping("/calculate")
    public double calculate(@RequestParam double averagePayment,
                            @RequestParam int vacationDays,
                            @RequestParam(required = false) @DateTimeFormat(pattern="ddMMyyyy") Date start) {
        Vacation.VacationBuilder vacationBuilder = new Vacation.VacationBuilder(averagePayment, vacationDays);
        if (start != null)
            vacationBuilder.setStart(start);
        return vacationBuilder.build().Calculate();
    }
}
