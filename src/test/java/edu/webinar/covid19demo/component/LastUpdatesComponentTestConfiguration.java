package edu.webinar.covid19demo.component;

import edu.webinar.covid19demo.controller.LastUpdatesController;
import edu.webinar.covid19demo.service.StatisticLastUpdatesCacheService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class LastUpdatesComponentTestConfiguration {

    @Bean
    public LastUpdatesController lastUpdatesController(StatisticLastUpdatesCacheService lastUpdatesService) {
        return new LastUpdatesController(lastUpdatesService);
    }

}
