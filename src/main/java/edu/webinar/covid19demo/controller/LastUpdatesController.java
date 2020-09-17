package edu.webinar.covid19demo.controller;

import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.service.StatisticLastUpdatesCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LastUpdatesController {

    private final StatisticLastUpdatesCacheService statisticService;

    @GetMapping("/statistic/last/{district}")
    public DailyStatistic getRecentStatistic(@PathVariable String district) {
        return statisticService.getLastStatistic(district).orElse(null);
    }
}
