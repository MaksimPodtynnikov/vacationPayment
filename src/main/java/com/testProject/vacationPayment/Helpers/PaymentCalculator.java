package com.testProject.vacationPayment.Helpers;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentCalculator {

    public static int getWorkDays(Date startPeriod, int vacation)
    {
        String start = new SimpleDateFormat("yyyyMMdd").format(startPeriod);
        Date endPeriod = DateUtils.addDays(startPeriod, vacation-1);
        String end = new SimpleDateFormat("yyyyMMdd").format(endPeriod);
        String uri = String.format("https://isdayoff.ru/api/getdata?date1=%s&date2=%s",start, end);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return countWorkDays(result);
    }
    private static int countWorkDays(String workCode)
    {
        return StringUtils.countMatches(workCode, "0");
    }
}
