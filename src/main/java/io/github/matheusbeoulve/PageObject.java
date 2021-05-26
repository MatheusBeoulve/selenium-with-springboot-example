package io.github.matheusbeoulve;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public abstract class PageObject {

    @Getter(AccessLevel.PROTECTED)
    private WebDriver webDriver;

    @Autowired
    void setWebDriver(@Lazy WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
