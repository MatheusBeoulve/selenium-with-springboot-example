package io.github.matheusbeoulve.pageobject;

import com.applitools.eyes.selenium.fluent.Target;
import io.github.matheusbeoulve.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ResultPageObject extends PageObject {

    @FindBy(css = "h3.LC20lb.DKV0Md")
    private WebElement titulosResultados;

    public ResultPageObject shouldReturnSearchResults() {

        expect(titulosResultados)
                .withTimeout(Duration.ofSeconds(5))
                .until(WebElement::isDisplayed);

        getEyes().check(Target.window().fully().withName("Results page"));

        return this;

    }
}
