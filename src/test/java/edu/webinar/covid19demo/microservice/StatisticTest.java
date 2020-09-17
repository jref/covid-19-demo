package edu.webinar.covid19demo.microservice;

import edu.webinar.covid19demo.factory.CovidStatisticFactory;
import edu.webinar.covid19demo.repository.StatisticRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StatisticTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StatisticRepository statisticRepository;

    @Test
    void totalStatisticTest() {
        statisticRepository.saveAll(CovidStatisticFactory.getStatistic());

        given()
                .port(port)
                .when()
                .get("/statistic/{district}", "kyiv")
                .then()
                .statusCode(200)
                .body("district", Matchers.equalTo("kyiv"))
                .body("allTimeSick", Matchers.equalTo(205))
                .body("currentlySick", Matchers.equalTo(159))
                .body("died", Matchers.equalTo(8))
                .body("cured", Matchers.equalTo(38));
    }
}
