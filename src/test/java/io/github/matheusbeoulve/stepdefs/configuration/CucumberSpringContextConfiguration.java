package io.github.matheusbeoulve.stepdefs.configuration;

import com.applitools.eyes.selenium.Eyes;
import io.cucumber.java8.En;
import io.cucumber.spring.CucumberContextConfiguration;
import io.github.matheusbeoulve.CucumberSpringConfiguration;
import io.github.matheusbeoulve.configuration.EyesConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = CucumberSpringConfiguration.class)
@CucumberContextConfiguration
public class CucumberSpringContextConfiguration implements En {

    @Autowired
    public CucumberSpringContextConfiguration(WebDriver webDriver,
                                              Eyes eyes,
                                              EyesConfiguration eyesConfiguration) {

        Before(scenario -> {

            log.info("Starting spring context for scenario.");

            eyes.open(webDriver, eyesConfiguration.getAppName(), scenario.getName());

            log.info("Opening Eyes.");

        });

        After(() -> {

            try {
                if(eyes.getIsOpen()) {
                    eyes.closeAsync();
                }
            } finally {
                eyes.abortAsync();
            }

            log.info("Closing Eyes.");

        });
    }
}
