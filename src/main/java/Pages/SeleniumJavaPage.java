package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeleniumJavaPage extends BasePage{
    WebDriver driver;

    public SeleniumJavaPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        PageFactory.initElements(this.driver, this);
    }


    @FindAll(@FindBy(how = How.CSS, using = "body > div.main-container.container-fluid > div > section > article"))
    private List<WebElement> elements_on_page;

//    ?"//*[@id="node-286"]/footer/ul/li[1]/a"

    public void openNthArticleOnPage(String numberOfArticle){
        int numberArticle = Integer.parseInt(numberOfArticle) - 1;
//        System.out.println(elements_on_page.get(0).getAttribute("id"));
//        for (WebElement el: elements_on_page){
//            System.out.println(el.getAttribute("id"));
//            System.out.println(el.getAttribute("about"));
//        }

        String articleId = elements_on_page.get(numberArticle).getAttribute("id");
//        #node-286 > footer > ul > li.node-readmore.first > a
        String button_CssLocator = "#" + articleId + " > footer > ul > li.node-readmore.first > a";
        WebElement btn_ReadMore = this.driver.findElement(By.cssSelector(button_CssLocator));
        btn_ReadMore.click();
    }


}