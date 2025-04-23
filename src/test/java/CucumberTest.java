import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.Fahmi.StepDefi"}, //tempat class file step definition
        features = {"src/test/resources"}, //letak gherkin berada
        plugin = {"pretty"} //untuk print hasil
)
    public class CucumberTest {

}
