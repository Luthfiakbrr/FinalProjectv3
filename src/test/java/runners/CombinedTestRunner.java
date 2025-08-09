package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources", // jalankan semua feature file di sini
        glue = {
                "api.steps",
                "web.steps",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:build/reports/cucumber/cucumber.html",
                "json:build/reports/cucumber/cucumber.json"
        },
        monochrome = true
)
public class CombinedTestRunner {
}
