package com.Fahmi.StepDefi;

import Page.HomePage;
import io.cucumber.java.en.Then;

public class HomePageStepDef extends BaseTest {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }
}
