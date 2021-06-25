package Managers;

import Managers.PageObjectManager;
//import Managers.WebDriverManager;

public class TestContext {
    private PageObjectManager pageObjectManager;

    public TestContext(){
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}