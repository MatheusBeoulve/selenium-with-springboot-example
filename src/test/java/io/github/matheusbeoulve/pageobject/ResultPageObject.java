package io.github.matheusbeoulve.pageobject;

import com.applitools.eyes.selenium.fluent.Target;
import io.cucumber.spring.ScenarioScope;
import io.github.matheusbeoulve.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.test.context.TestComponent;

import java.time.Duration;

@TestComponent
public class ResultPageObject extends PageObject {

    @FindBy(css = "h3.LC20lb.DKV0Md")
    private WebElement titulosResultados;

    public ResultPageObject shouldReturnSearchResults() {

        expect(titulosResultados)
                .withTimeout(Duration.ofSeconds(5))
                .until(WebElement::isDisplayed);

        getEyes().check(Target.window().fully().layout().withName("Results page"));

        return this;

    }
}
