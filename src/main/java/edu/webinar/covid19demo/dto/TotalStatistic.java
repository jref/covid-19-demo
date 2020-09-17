package edu.webinar.covid19demo.dto;

import lombok.Data;

@Data
public class TotalStatistic {

    private String district;

    private int allTimeSick;

    private int currentlySick;

    private int died;

    private int cured;


}
