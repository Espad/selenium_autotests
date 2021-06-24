package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends BasePage{
    WebDriver driver;

    public MainPage(WebDriver webDriver) {
        super();
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = ".btn.btn-success"))
    public List<WebElement> btn_List;


    public void checkPageUrl(String shouldBeUrl){
        String currentUrl = this.driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(shouldBeUrl));
    }

    public void checkPageTitle(String shouldBeTitle){
        String currentPageTitle = this.driver.getTitle();
        System.out.println(currentPageTitle);
        Assert.assertTrue(currentPageTitle.contains(shouldBeTitle));
    }

    public void click_GoToTestPage() {
        btn_List.get(0).click();

    }

}