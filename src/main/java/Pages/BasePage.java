package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.Scenario;


public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;
    public String runNumber;

    public BasePage(WebDriver driver){
        this.driver = driver;
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

    public void checkPageUrl(String shouldBeUrl){
        String currentUrl = this.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(shouldBeUrl));
    }

    public void checkPageTitle(String shouldBeTitle){
        String currentPageTitle = this.driver.getTitle();
        Assert.assertTrue(currentPageTitle.contains(shouldBeTitle));
    }

}
