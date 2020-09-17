package edu.webinar.covid19demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "covid_19_statustic")
@Data
public class CovidStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    private String district;

    private int sick;

    private int died;

    private int cured;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof CovidStatistic))
            return false;

        CovidStatistic other = (CovidStatistic) o;

        return id != null &&
                id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
