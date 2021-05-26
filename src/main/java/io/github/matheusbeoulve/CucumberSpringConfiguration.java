package io.github.matheusbeoulve;

import io.cucumber.spring.ScenarioScope;
import io.github.matheusbeoulve.configuration.WebdriverConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan
@ConfigurationPropertiesScan
public class CucumberSpringConfiguration {

    @Autowired
    WebdriverConfiguration webDriverConfiguration;

    @Bean
    @ScenarioScope
    public WebDriver webDriver() {
        return RemoteWebDriver.builder()
                .url(webDriverConfiguration.getUrl())
                .oneOf(new ChromeOptions(),
                       new FirefoxOptions(),
                       new EdgeOptions(),
                       new InternetExplorerOptions())
                .build();
    }
}
