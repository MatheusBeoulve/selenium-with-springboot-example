package io.github.matheusbeoulve.pageobject;

import io.github.matheusbeoulve.PageObject;
import org.springframework.stereotype.Component;

@Component
public class HomePageObject extends PageObject {

    public void gotoGoogle() {
        getWebDriver().get("http://google.com/");
    }
}
