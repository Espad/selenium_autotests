package Steps;

import Managers.TestContext;
import Pages.BasePage;
import Pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MainPageSteps {
    TestContext testContext;
    MainPage mainPage;

    public MainPageSteps(TestContext context) {
        testContext = context;
        mainPage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("User is on {string} page")
    public void goToWebPage(String webPage) {
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

    @When("user returned on page {string} title {string}")
    public void comeBackOnManePageCheck(String shouldBeUrl, String title) {
        mainPage.checkPageUrl(shouldBeUrl);
        mainPage.checkPageTitle(title);
    }

    @When("user go to selenium with java page")
    public void goToSeleniumJavaPage(){
        mainPage.click_SeleniumMenu();
        mainPage.click_SeleniumWithJava();
    }






}