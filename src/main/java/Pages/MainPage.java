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
        super(webDriver);
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }

    @FindAll(@FindBy(how = How.CSS, using = ".btn.btn-success"))
    private List<WebElement> btn_List;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbar-collapse\"]/nav/ul/li[2]/a")
    private WebElement btn_SeleniumMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"navbar-collapse\"]/nav/ul/li[2]/ul/li[1]/a"    )
    private WebElement btn_SeleniumWithJava;

    public void click_GoToTestPage() {
        btn_List.get(0).click();
    }

    public void click_SeleniumMenu(){
        btn_SeleniumMenu.click();
    }

    public void click_SeleniumWithJava(){
        btn_SeleniumWithJava.click();
    }

}