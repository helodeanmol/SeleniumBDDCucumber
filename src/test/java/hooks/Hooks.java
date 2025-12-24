package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Before hook: Setting up WebDriver");
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        // Common setup for all browsers
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario) {
        // This block executes after each scenario.
        // If the scenario fails, it takes a screenshot.
        if (scenario.isFailed()) {
            System.out.println("Scenario failed! Capturing screenshot...");
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // Attach screenshot to the report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Always quit the driver to clean up resources.
//        if (driver != null) {
//            driver.quit();
//        }
    }
}