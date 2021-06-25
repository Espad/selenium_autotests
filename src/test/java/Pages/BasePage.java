package Pages;

import Managers.Hook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;
    public String runNumber;

    public BasePage(){
        this.runNumber = Hook.runNumber;
        this.driver = Hook.driver;
        long timeOutInSeconds = 10; // just an arbitrary value example
        this.wait = new WebDriverWait(this.driver, timeOutInSeconds);
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void goToPage(String webPage){
        this.driver.get(webPage);
    }

    public void getScreenShot(String path) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)this.driver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        // Move image file to new destination
        File DestFile=new File(path);

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}
