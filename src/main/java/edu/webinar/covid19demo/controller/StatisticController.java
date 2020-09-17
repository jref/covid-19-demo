package edu.webinar.covid19demo.controller;

import edu.webinar.covid19demo.dto.DailyStatistic;
import edu.webinar.covid19demo.dto.TotalStatistic;
import edu.webinar.covid19demo.entity.CovidStatistic;
import edu.webinar.covid19demo.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("/statistic")
    public void addDailyStatistic(@RequestBody DailyStatistic dailyStatistic) {
        statisticService.addDailyStatistic(dailyStatistic);
    }

    @GetMapping("/statistic/{district}/{day}")
    public DailyStatistic getDailyStatisticByDistrict(@PathVariable String district, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {
        return statisticService.getDailyStatisticByDistrict(district, day);
    }

    @GetMapping("/statistic/{district}")
    public TotalStatistic getTotalStatisticByDistrict(@PathVariable String district) {
        return statisticService.getTotalStatisticByDistrict(district);
    }
}
