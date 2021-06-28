package Steps;

import Managers.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hook {

    public static WebDriver driver;
    public static String runNumber;
    TestContext testContext;

    public Hook(TestContext context) {
        testContext = context;
    }

    @Before
    public void initDriver() {
        System.out.println("create driver via hook");
    }

    @After(order = 1)
    public void getScreenShot(Scenario scenario) throws IOException {
        System.out.println("make screenshot");
        runNumber = scenario.getName() + "_feature file line number_" + scenario.getId().split(":")[3];
        String path = "C:\\Users\\test_user\\Downloads\\" + runNumber + ".png";
        TakesScreenshot scrShot =((TakesScreenshot) testContext.getWebDriverManager().getDriver());

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile=new File(path);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }

    @After(order = 0)
    public void teardown() {
        System.out.println("close driver via hook");
//        driver.quit();
        testContext.getWebDriverManager().closeDriver();

    }
}