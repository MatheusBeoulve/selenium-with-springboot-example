package io.github.matheusbeoulve;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

@Cucumber
public class CucumberTest {

    @Autowired
    static WebDriver webDriver;

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
