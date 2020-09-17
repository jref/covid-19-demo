package edu.webinar.covid19demo.repository;

import edu.webinar.covid19demo.entity.CovidStatistic;
import edu.webinar.covid19demo.factory.CovidStatisticFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class StatisticRepositoryTest {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findByDateAndDistrict() {
        List<CovidStatistic> statistic = prepareDatabase();

        CovidStatistic actual = statisticRepository.findByDateAndDistrict(LocalDate.of(2020, Month.SEPTEMBER, 16), "kyiv").orElse(null);
        Assertions.assertThat(actual).isEqualToComparingFieldByField(statistic.get(1));
    }

    @Test
    void findByDateAndDistrictEmptyResult() {
        Optional<CovidStatistic> actual = statisticRepository.findByDateAndDistrict(LocalDate.of(2020, Month.SEPTEMBER, 16), "kyiv");
        org.junit.jupiter.api.Assertions.assertEquals(Optional.empty(), actual);
    }

    private List<CovidStatistic> prepareDatabase() {
        List<CovidStatistic> statistic = CovidStatisticFactory.getStatistic();
        statistic.stream().peek(covidStatistic -> covidStatistic.setId(null)).forEach(stat -> testEntityManager.persistAndFlush(stat));
        return statistic;
    }
}
