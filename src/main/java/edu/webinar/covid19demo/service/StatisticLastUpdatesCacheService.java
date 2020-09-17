package edu.webinar.covid19demo.service;

import edu.webinar.covid19demo.dto.DailyStatistic;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StatisticLastUpdatesCacheService {

    private final Map<String, DailyStatistic> statisticCache = new HashMap<>();

    public StatisticLastUpdatesCacheService() {
        System.out.println("Hello!!!");
    }

    public void updateStatistic(DailyStatistic dailyStatistic) {
        DailyStatistic lastStatistic = statisticCache.get(dailyStatistic.getDistrict());
        if (lastStatistic == null) {
            statisticCache.put(dailyStatistic.getDistrict(), dailyStatistic);
            return;
        }
        if (lastStatistic.getDate().isBefore(dailyStatistic.getDate())) {
            statisticCache.put(dailyStatistic.getDistrict(), dailyStatistic);
        }
    }

    public Optional<DailyStatistic> getLastStatistic(String district) {
        return Optional.ofNullable(statisticCache.get(district));
    }
}
