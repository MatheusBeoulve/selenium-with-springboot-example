package io.github.matheusbeoulve.pageobject;

import com.applitools.eyes.selenium.fluent.Target;
import io.github.matheusbeoulve.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.test.context.TestComponent;

import java.time.Duration;

@TestComponent
public class HomePageObject extends PageObject {

    @FindBy(css = "input[name=q]")
    private WebElement searchBar;

    public HomePageObject gotoGoogle() {

        String google = "http://google.com/";

        getWebDriver().get(google);

        return this;

    }

    public HomePageObject search(String what) {

        expect(searchBar)
                .withTimeout(Duration.ofSeconds(5))
                .until(WebElement::isDisplayed);

        getEyes().check(Target.window().fully().withName("Home Page"));

        searchBar.sendKeys(what);
        searchBar.submit();

        return this;

    }
}