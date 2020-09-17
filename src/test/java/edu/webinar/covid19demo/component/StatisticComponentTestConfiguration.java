package edu.webinar.covid19demo.component;

import edu.webinar.covid19demo.controller.StatisticController;
import edu.webinar.covid19demo.repository.StatisticRepository;
import edu.webinar.covid19demo.service.StatisticLastUpdatesCacheService;
import edu.webinar.covid19demo.service.StatisticService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class StatisticComponentTestConfiguration {

    @Bean
    public StatisticController statisticController(StatisticService statisticService) {
        return new StatisticController(statisticService);
    }

    @Bean
    public StatisticService statisticService(StatisticLastUpdatesCacheService statisticLastUpdatesCacheService) {
        return new StatisticService(Mockito.mock(StatisticRepository.class), statisticLastUpdatesCacheService);
    }




}
