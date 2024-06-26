import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue = {"step_definitions", "hooks"},
        tags = {"~@Ignore", "@Demo"})
public class CucumberRunner {

}
