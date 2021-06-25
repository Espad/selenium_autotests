package Managers;

import org.openqa.selenium.WebDriver;

import Pages.TestPage;
import Pages.MainPage;


public class PageObjectManager {

    private WebDriver driver;
    private TestPage testPage;
    private MainPage mainPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getHomePage(){
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public TestPage getTestPage() {
        return (testPage == null) ? testPage = new TestPage(driver) : testPage;
    }
}