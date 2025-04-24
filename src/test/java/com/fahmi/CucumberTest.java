package com.fahmi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.fahmi.stepDefinitions"}, //tempat class file step definition
        features = {"src/test/resources/features"}, //letak gherkin berada
        plugin = {"pretty"} //untuk print hasil
)
    public class CucumberTest {

}
