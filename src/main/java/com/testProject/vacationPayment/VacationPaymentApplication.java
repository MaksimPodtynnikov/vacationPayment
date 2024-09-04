package com.testProject.vacationPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VacationPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationPaymentApplication.class, args);
	}
}
