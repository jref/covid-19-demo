package edu.webinar.covid19demo.factory;

import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.entity.CovidStatistic;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CovidStatisticFactory {

    public static List<CovidStatistic> getStatistic() {
        CovidStatistic covidStatistic1 = new CovidStatistic();
        covidStatistic1.setId(1L);
        covidStatistic1.setDistrict("kyiv");
        covidStatistic1.setSick(100);
        covidStatistic1.setDied(5);
        covidStatistic1.setCured(15);
        covidStatistic1.setDate(LocalDate.of(2020, Month.SEPTEMBER, 15));
        CovidStatistic covidStatistic2 = new CovidStatistic();
        covidStatistic2.setId(2L);
        covidStatistic2.setDistrict("kyiv");
        covidStatistic2.setSick(105);
        covidStatistic2.setDied(3);
        covidStatistic2.setCured(23);
        covidStatistic2.setDate(LocalDate.of(2020, Month.SEPTEMBER, 16));
        CovidStatistic covidStatistic3 = new CovidStatistic();
        covidStatistic3.setId(3L);
        covidStatistic3.setDistrict("kharkiv");
        covidStatistic3.setSick(98);
        covidStatistic3.setDied(1);
        covidStatistic3.setCured(12);
        covidStatistic3.setDate(LocalDate.of(2020, Month.SEPTEMBER, 16));
        return List.of(covidStatistic1, covidStatistic2, covidStatistic3);
    }

    public static List<CovidStatistic> getKyivStatistic() {
        CovidStatistic covidStatistic1 = new CovidStatistic();
        covidStatistic1.setId(1L);
        covidStatistic1.setDistrict("kyiv");
        covidStatistic1.setSick(100);
        covidStatistic1.setDied(5);
        covidStatistic1.setCured(15);
        covidStatistic1.setDate(LocalDate.of(2020, Month.SEPTEMBER, 15));
        CovidStatistic covidStatistic2 = new CovidStatistic();
        covidStatistic2.setId(2L);
        covidStatistic2.setDistrict("kyiv");
        covidStatistic2.setSick(105);
        covidStatistic2.setDied(3);
        covidStatistic2.setCured(23);
        covidStatistic2.setDate(LocalDate.of(2020, Month.SEPTEMBER, 16));
        return List.of(covidStatistic1, covidStatistic2);
    }

    public static DailyStatistic getDailyStatistic() {
        DailyStatistic dailyStatistic = new DailyStatistic();
        dailyStatistic.setDistrict("kyiv");
        dailyStatistic.setSick(200);
        dailyStatistic.setDied(2);
        dailyStatistic.setCured(20);
        dailyStatistic.setDate(LocalDate.of(2020, Month.SEPTEMBER, 12));
        return dailyStatistic;
    }
}
