package edu.webinar.covid19demo.service;

import edu.webinar.covid19demo.dto.TotalStatistic;
import edu.webinar.covid19demo.factory.CovidStatisticFactory;
import edu.webinar.covid19demo.repository.StatisticRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StatisticServiceTest {

    private StatisticRepository statisticRepository = mock(StatisticRepository.class);
    private StatisticLastUpdatesCacheService statisticLastUpdatesCacheService = mock(StatisticLastUpdatesCacheService.class);
    private StatisticService statisticService = new StatisticService(statisticRepository, statisticLastUpdatesCacheService);

    @Test
    void getTotalStatistic() {
        //given
        when(statisticRepository.findAllByDistrict("kyiv")).thenReturn(CovidStatisticFactory.getKyivStatistic());

        //when
        TotalStatistic actual = statisticService.getTotalStatisticByDistrict("kyiv");

        //then
        TotalStatistic expected = new TotalStatistic();
        expected.setDistrict("kyiv");
        expected.setCurrentlySick(159);
        expected.setAllTimeSick(205);
        expected.setDied(8);
        expected.setCured(38);
        assertEquals(expected, actual);
    }

    @Test
    void getTotalStatisticEmptyResult() {
        //given
        when(statisticRepository.findAllByDistrict("kharkiv")).thenReturn(Collections.emptyList());

        //when
        TotalStatistic actual = statisticService.getTotalStatisticByDistrict("kharkiv");

        //then
        TotalStatistic expected = new TotalStatistic();
        assertEquals(expected, actual);

    }
}