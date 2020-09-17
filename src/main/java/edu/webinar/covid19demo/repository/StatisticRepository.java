package edu.webinar.covid19demo.repository;

import edu.webinar.covid19demo.entity.CovidStatistic;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StatisticRepository extends CrudRepository<CovidStatistic, Long> {

    Optional<CovidStatistic> findByDateAndDistrict(LocalDate date, String district);

    List<CovidStatistic> findAllByDistrict(String district);
}
