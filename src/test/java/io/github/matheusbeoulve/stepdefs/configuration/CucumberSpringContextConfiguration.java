package io.github.matheusbeoulve.stepdefs.configuration;

import io.cucumber.java8.En;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.matheusbeoulve.CucumberSpringConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = CucumberSpringConfiguration.class)
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration implements En {

    public CucumberSpringContextConfiguration() {
        Before(() -> {
            log.info("Starting spring context for scenario");
        });
    }
}
