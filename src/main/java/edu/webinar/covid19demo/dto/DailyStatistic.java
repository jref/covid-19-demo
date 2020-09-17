package edu.webinar.covid19demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DailyStatistic {

    private LocalDate date;

    private String district;

    private int sick;

    private int died;

    private int cured;
}
