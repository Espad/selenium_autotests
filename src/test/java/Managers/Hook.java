package Managers;

import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;

public class Hook {

    public static WebDriver driver;
    public static String runNumber;


    @Before
    public void initDriver() throws Exception {

        int timeOutInSeconds = 5;
        System.out.println("Open browser");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("platform", "Windows 10");
        options.setCapability("version", 91.0);
        options.setCapability("browserName", "chrome");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(timeOutInSeconds, TimeUnit.SECONDS);

    }

    @Before(order = 1)
    public String before(Scenario scenario) {
//        this.scenario = scenario;
        runNumber = scenario.getName() + "_feature file line number_" + scenario.getId().split(":")[2];
        return runNumber;
    }

    @After
    public void teardown() {
        System.out.println("Close browser");
        driver.quit();
    }
}