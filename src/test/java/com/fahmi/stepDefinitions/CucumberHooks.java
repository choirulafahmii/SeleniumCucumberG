package com.fahmi.stepDefinitions;

import com.fahmi.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static java.sql.DriverManager.getDriver;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
