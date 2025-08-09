package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before(order = 0)
    public void beforeScenario(Scenario scenario){
        String tags = System.getProperty("cucumber.filter.tags", "");
        if (tags.contains("@web") || scenario.getSourceTagNames().stream().anyMatch(t -> t.equals("@web"))) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
