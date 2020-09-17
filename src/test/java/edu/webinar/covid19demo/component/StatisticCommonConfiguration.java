package edu.webinar.covid19demo.component;

import edu.webinar.covid19demo.service.StatisticLastUpdatesCacheService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class StatisticCommonConfiguration {

    @Bean
    public StatisticLastUpdatesCacheService statisticLastUpdatesCacheService() {
        return new StatisticLastUpdatesCacheService();
    }
}
