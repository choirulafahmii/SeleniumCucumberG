package com.Fahmi.StepDefi;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class LoginStepDef {

    WebDriver driver;

    @Before
    public void beforeTest(){
        driver = WebDriverManager.chromedriver().create();
    }

    @After
    public void afterTest(){

    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {

    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        
    }

    @When("user click login button")
    public void userClickLoginButton() {
        
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
    }


    @And("user see error message")
    public void userSeeErrorMessage() {
    }
}
