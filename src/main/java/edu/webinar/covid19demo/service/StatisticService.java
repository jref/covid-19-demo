package edu.webinar.covid19demo.service;

import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.dto.TotalStatistic;
import edu.webinar.covid19demo.entity.CovidStatistic;
import edu.webinar.covid19demo.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;
    private final StatisticLastUpdatesCacheService statisticLastUpdatesCacheService;

    public void addDailyStatistic(DailyStatistic dailyStatistic) {
        CovidStatistic covidStatistic = new CovidStatistic();
        covidStatistic.setDate(dailyStatistic.getDate());
        covidStatistic.setDistrict(dailyStatistic.getDistrict());
        covidStatistic.setSick(dailyStatistic.getSick());
        covidStatistic.setDied(dailyStatistic.getDied());
        covidStatistic.setCured(dailyStatistic.getCured());
        statisticLastUpdatesCacheService.updateStatistic(dailyStatistic);
        addDailyStatistic(covidStatistic);
    }

    public void addDailyStatistic(CovidStatistic covidStatistic) {
        statisticRepository.save(covidStatistic);
    }

    public DailyStatistic getDailyStatisticByDistrict(String district, LocalDate day) {
        Optional<DailyStatistic> lastStatistic = statisticLastUpdatesCacheService.getLastStatistic(district).filter(statistic -> statistic.getDate().equals(day));
        if (lastStatistic.isPresent()) {
            return lastStatistic.get();
        }
        CovidStatistic covidStatistic = statisticRepository.findByDateAndDistrict(day, district).orElseThrow();
        DailyStatistic dailyStatistic = new DailyStatistic();
        dailyStatistic.setSick(covidStatistic.getSick());
        dailyStatistic.setCured(covidStatistic.getCured());
        dailyStatistic.setDate(covidStatistic.getDate());
        dailyStatistic.setDistrict(covidStatistic.getDistrict());
        dailyStatistic.setDied(covidStatistic.getDied());
        return dailyStatistic;
    }

    public TotalStatistic getTotalStatisticByDistrict(String district) {
        List<CovidStatistic> statistics = statisticRepository.findAllByDistrict(district);
        CovidStatistic sumStatistic = statistics.stream()
                .reduce(new CovidStatistic(), this::statisticSum);
        TotalStatistic totalStatistic = new TotalStatistic();
        totalStatistic.setAllTimeSick(sumStatistic.getSick());
        totalStatistic.setDied(sumStatistic.getDied());
        totalStatistic.setCured(sumStatistic.getCured());
        totalStatistic.setCurrentlySick(sumStatistic.getSick() - sumStatistic.getDied() - sumStatistic.getCured());
        totalStatistic.setDistrict(sumStatistic.getDistrict());
        return totalStatistic;
    }

    private CovidStatistic statisticSum(CovidStatistic statistic1, CovidStatistic statistic2) {
        statistic1.setSick(statistic1.getSick() + statistic2.getSick());
        statistic1.setDied(statistic1.getDied() + statistic2.getDied());
        statistic1.setCured(statistic1.getCured() + statistic2.getCured());
        statistic1.setDistrict(statistic2.getDistrict());
        return statistic1;
    }

}
