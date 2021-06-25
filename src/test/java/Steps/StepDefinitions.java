package Steps;

import Pages.BasePage;
import Pages.MainPage;
import Managers.PageObjectManager;
import Pages.TestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;


public class StepDefinitions{
    WebDriver driver;
    BasePage basePage;
    MainPage mainPage;
    TestPage testPage;
    PageObjectManager pageObjectManager;

    @Given("User is on {string} page")
    public void goToWebPage(String webPage) {
        basePage = new BasePage();
        pageObjectManager = new PageObjectManager(basePage.getDriver());
        mainPage = pageObjectManager.getHomePage();
        mainPage.goToPage(webPage);
    }

    @When("I am on the {string} page")
    public void iAmOnPage(String shouldBeUrl) {
        mainPage.checkPageUrl(shouldBeUrl);
    }

    @Then("the page title should be {string}")
    public void checkPageTitle(String title) {
        mainPage.checkPageTitle(title);
    }

    @Then("user go to test page by clicking button Demo Website")
    public void goToTestPage() {
        mainPage.click_GoToTestPage();
    }

    @Then("click on root element")
    public void expandTree() {
        testPage = pageObjectManager.getTestPage();
        // popup can be shown on page
        testPage.closePopupRegistration();
        testPage.clickOn_ExpandTree();

    }

    @Then("click on form submit element")
    public void chooseInputFormSubmitElement() {
        testPage.clickOn_btnFormSubmitTreeElement();
    }


    

    @Then("fill forms with data {string} and submit")
    public void fillFormAndSubmit(String result) throws IOException {
        List<String> items = Arrays.asList(result.split("\\s*;\\s*"));
        testPage.fillFormData(items);
        testPage.getScreenShot("C:\\Users\\test_user\\Downloads\\" + basePage.runNumber + ".png");
        testPage.submitFormData();
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

    }


}