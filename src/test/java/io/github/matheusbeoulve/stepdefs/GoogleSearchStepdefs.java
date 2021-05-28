package io.github.matheusbeoulve.stepdefs;

import io.cucumber.java8.En;
import io.cucumber.spring.ScenarioScope;
import io.github.matheusbeoulve.pageobject.HomePageObject;
import io.github.matheusbeoulve.pageobject.ResultPageObject;
import org.springframework.beans.factory.annotation.Autowired;

@ScenarioScope
public class GoogleSearchStepdefs implements En {

    @Autowired
    public GoogleSearchStepdefs(HomePageObject homePageObject,
                                ResultPageObject resultPageObject) {

        Given("^im totally in need for some (.*)$", something -> {
            homePageObject.gotoGoogle();
        });

        When("^search for (.*)$", homePageObject::search);

        Then("^i find some amazing (.*)$", something -> {
            resultPageObject.shouldReturnSearchResults();
        });

    }
}
