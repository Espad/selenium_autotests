package Steps;

import Managers.TestContext;
import Pages.MainPage;
import Pages.SeleniumJavaPage;
import io.cucumber.java.en.Then;

public class SeleniumJavaPageSteps {
    TestContext testContext;
    SeleniumJavaPage seleniumJavaPagePage;

    public SeleniumJavaPageSteps(TestContext context) {
        testContext = context;
        seleniumJavaPagePage = testContext.getPageObjectManager().getSeleniumJavaPage();
    }

    @Then("page and title should be {string} {string}")
    public void checkTitleAndLinkOnJavaSeleniumPage(String shouldBeUrl, String title) {
        seleniumJavaPagePage.checkPageUrl(shouldBeUrl);
        seleniumJavaPagePage.checkPageTitle(title);

    }

    @Then("user opens {string} on page")
    public void openNthArticleOnPage(String article_number) {
        seleniumJavaPagePage.openNthArticleOnPage(article_number);
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
