package Managers;

import Pages.BasePage;
import Pages.SeleniumJavaPage;
import org.openqa.selenium.WebDriver;

import Pages.TestPage;
import Pages.MainPage;


public class PageObjectManager {

    private WebDriver driver;
    private TestPage testPage;
    private MainPage mainPage;
    private BasePage basePage;
    private SeleniumJavaPage seleniumJavaPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getBasePage(){
        return (basePage == null) ? basePage = new BasePage(driver) : basePage;
    }

    public MainPage getHomePage(){
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public TestPage getTestPage() {
        return (testPage == null) ? testPage = new TestPage(driver) : testPage;
    }

    public SeleniumJavaPage getSeleniumJavaPage() {
        return (seleniumJavaPage == null) ? seleniumJavaPage = new SeleniumJavaPage(driver) : seleniumJavaPage;
    }

}