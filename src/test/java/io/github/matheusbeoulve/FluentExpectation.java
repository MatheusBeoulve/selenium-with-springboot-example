package io.github.matheusbeoulve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public interface FluentExpectation extends WebDriverWrapper {

    default FluentWait<WebDriver> expect() {
        return new FluentWait<>(getWebDriver());
    }

    default  <T> FluentWait<T> expect(T o) {
        return new FluentWait<>(o);
    }
}
