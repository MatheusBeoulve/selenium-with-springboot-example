package io.github.matheusbeoulve;

import com.applitools.eyes.selenium.Eyes;
import io.github.matheusbeoulve.configuration.WebDriverConfiguration;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public abstract class PageObject implements FluentExpectation {

    @Autowired
    public WebDriverConfiguration webDriverConfiguration;

    @Autowired
    @Getter
    public Eyes eyes;

    @Autowired
    @Getter
    public WebDriver webDriver;

    @PostConstruct
    private void configureWebDriver() {
        PageFactory.initElements(getWebDriver(), this);
        getWebDriver()
                .manage()
                .timeouts()
                .implicitlyWait(
                        webDriverConfiguration.getImplicitlyTimeout(),
                        TimeUnit.SECONDS
                );
    }
}
