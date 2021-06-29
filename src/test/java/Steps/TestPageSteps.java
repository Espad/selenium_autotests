package Steps;

import DataTypes.FillFormData;
import Managers.FileReaderManager;
import Managers.TestContext;
import Pages.BasePage;
import Pages.MainPage;
import Pages.TestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TestPageSteps {
    TestContext testContext;
    TestPage testPage;

    public TestPageSteps(TestContext context) {
        testContext = context;
        testPage = testContext.getPageObjectManager().getTestPage();
    }

    // add check that user is on test page

    @Then("click on root element")
    public void expandTree() {
        // popup can be shown on page
        testPage = testContext.getPageObjectManager().getTestPage();
        testPage.closePopupRegistration();
        testPage.clickOn_ExpandTree();

    }

    @Then("click on form submit element")
    public void chooseInputFormSubmitElement() {
        testPage.clickOn_btnFormSubmitTreeElement();
    }


    @Then("fill forms with data {string} and submit")
    public void fillFormAndSubmit(String result) {
        List<String> items = Arrays.asList(result.split("\\s*;\\s*"));
        testPage.fillFormData(items);
        testPage.submitFormData();


    }

    @Then("fill forms with data from json and name {string} and submit")
    public void fillFormAndSubmitJson(String customerName) {
        FillFormData customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        testPage.fillFormDataWithDataType(customer);
        testPage.submitFormData();

    }

    @Then("user go back to main page")
    public void goToMainPage(){
        testPage.goBackFromTestPageToMainPage();
    }


}