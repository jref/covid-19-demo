package edu.webinar.covid19demo.component;

import edu.webinar.covid19demo.controller.LastUpdatesController;
import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.factory.CovidStatisticFactory;
import edu.webinar.covid19demo.service.StatisticLastUpdatesCacheService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {StatisticCommonConfiguration.class, LastUpdatesComponentTestConfiguration.class})
public class LastUpdatesComponentTest {

    @Autowired
    private StatisticLastUpdatesCacheService statisticLastUpdatesCacheService;

    @Autowired
    private LastUpdatesController lastUpdatesController;

    @Test
    void getLatUpdatesForKyiv() {
        //given
        DailyStatistic dailyStatistic = CovidStatisticFactory.getDailyStatistic();
        statisticLastUpdatesCacheService.updateStatistic(dailyStatistic);

        //when
        DailyStatistic actual = lastUpdatesController.getRecentStatistic("kyiv");

        Assertions.assertEquals(dailyStatistic, actual);
    }
}
