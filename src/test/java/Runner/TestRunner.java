package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //dryRun = false,
        features = "C:\\Users\\demir\\Cucumber2_Iq\\src\\test\\java\\features\\login.feature",
        glue = "stepDefs",
        //tags = "@multipleUsers",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml"}
)

public class TestRunner {

}
