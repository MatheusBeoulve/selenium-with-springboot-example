package io.github.matheusbeoulve;

import com.applitools.eyes.selenium.Eyes;
import io.github.matheusbeoulve.configuration.WebDriverConfiguration;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

public abstract class PageObject {

    @Autowired
    private WebDriverConfiguration webDriverConfiguration;

    @Autowired
    @Getter(AccessLevel.PROTECTED)
    private Eyes eyes;

    @Getter(AccessLevel.PROTECTED)
    private WebDriver webDriver;

    @Autowired
    private void setWebDriver(@Lazy WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @PostConstruct
    private void pageFactoryInitElements() {
        PageFactory.initElements(getWebDriver(), this);
    }

    @PostConstruct
    private void implicitlyWaitTimeout() {
        getWebDriver().manage().timeouts()
                .implicitlyWait(webDriverConfiguration.getImplicitlyTimeout(), TimeUnit.SECONDS);
    }

    protected FluentWait<WebDriver> expect() {
        return new FluentWait<>(getWebDriver());
    }

    protected <T> FluentWait<T> expect(T o) {
        return new FluentWait<>(o);
    }
}
