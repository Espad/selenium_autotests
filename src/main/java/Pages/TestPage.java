package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestPage extends BasePage {
    WebDriver driver;

    public TestPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.CSS, using = "#treemenu > li > ul > li:nth-child(1) > i")
    private WebElement btn_ExpandInputFormsSubtree;

    @FindBy(how = How.CSS, using = "#treemenu > li > ul > li:nth-child(1) > ul > li:nth-child(5) > a")
    private WebElement element_InputFormSubmit;

    @FindBy(how = How.CSS, using = "#at-cv-lightbox-button-holder > a.at-cv-button.at-cv-lightbox-yesno.at-cm-no-button")
    private WebElement btn_ClosePopup;

    //    form elements data
    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(2) > div > div > input")
    private WebElement input_FormName;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(3) > div > div > input")
    private WebElement input_FormSecondName;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(4) > div > div > input")
    private WebElement input_FormEmail;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(5) > div > div > input")
    private WebElement input_FormPhone;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(6) > div > div > input")
    private WebElement input_FormAddress;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(7) > div > div > input")
    private WebElement input_FormCity;

    @FindBy(how = How.XPATH, using = "//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select")
    private WebElement list_States;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(9) > div > div > input")
    private WebElement input_FormZipCode;

    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(12) > div > div > textarea")
    private WebElement input_FormProjectDescription;


    @FindBy(how = How.CSS, using = "#contact_form > fieldset > div:nth-child(14) > div > button")
    private WebElement btn_SubmitFormData;

    @FindBy(how = How.CSS, using = "#site-name > a")
    private WebElement btn_backToMainPage;


    public void closePopupRegistration(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        WebElement btn_Close = wait.until(ExpectedConditions.elementToBeClickable(btn_ClosePopup));
        btn_Close.click();
    }

    public void clickOn_ExpandTree() {
        btn_ExpandInputFormsSubtree.click();

    }
    public void clickOn_btnFormSubmitTreeElement() {
        element_InputFormSubmit.click();
    }

    public void fillFormData(List<String> items) {
        input_FormName.sendKeys(items.get(0));
        input_FormSecondName.sendKeys(items.get(1));
        input_FormEmail.sendKeys(items.get(2));
        input_FormPhone.sendKeys(items.get(3));
        input_FormAddress.sendKeys(items.get(4));
        input_FormCity.sendKeys(items.get(5));

        Select dropdown = new Select(list_States);
        dropdown.selectByVisibleText(items.get(6));

        input_FormZipCode.sendKeys(items.get(7));
        input_FormProjectDescription.sendKeys(items.get(8));

    }

    public void submitFormData() {
        btn_SubmitFormData.click();
    }

    public void goBackFromTestPageToMainPage(){
        btn_backToMainPage.click();
    }

}
