package io.github.matheusbeoulve.stepdefs;

import io.cucumber.java8.En;
import io.cucumber.spring.ScenarioScope;
import io.github.matheusbeoulve.pageobject.HomePageObject;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class GoogleSearchStepdefs implements En {

    @Autowired
    public GoogleSearchStepdefs(HomePageObject homePageObject) {

        Given("^im totally in need for some puff puff dogo$", () -> {
            homePageObject.gotoGoogle();
        });

        When("^search for puff puff dog$", () -> {
        });

        Then("^i find some amazing dogo puff stuff$", () -> {
        });
    }
}
