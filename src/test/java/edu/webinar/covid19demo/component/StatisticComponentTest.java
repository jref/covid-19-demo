package edu.webinar.covid19demo.component;

import edu.webinar.covid19demo.controller.StatisticController;
import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.factory.CovidStatisticFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {StatisticCommonConfiguration.class, StatisticComponentTestConfiguration.class})
public class StatisticComponentTest {

    @Autowired
    private StatisticController statisticController;

    @Test
    void getDailyStatistic() {
        //given
        DailyStatistic dailyStatistic = CovidStatisticFactory.getDailyStatistic();
        statisticController.addDailyStatistic(dailyStatistic);

        //when
        DailyStatistic actual = statisticController.getDailyStatisticByDistrict("kyiv", LocalDate.of(2020, Month.SEPTEMBER, 12));

        //then
        assertEquals(dailyStatistic, actual);
    }
}
