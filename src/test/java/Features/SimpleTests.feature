Feature: Test selenium easy website
    # The first example has 4 steps
    Scenario Outline: Go to website
    Given User is on "<webPage>" page
    When I am on the "<webPage>" page
    Then the page title should be "<title_main>"
    Then user go to test page by clicking button Demo Website
    Then click on root element
    Then click on form submit element
    Then fill forms with data "<result_list>" and submit
    Then user go back to main page
    When user returned on page "<webPage>" title "<title_main>"
    When user go to selenium with java page
    Then page and title should be "<webpageSeleniumWithJava>" "<title_selenium_with_java>"
    Examples:
      | webPage                       | title_main                                                       | webpageSeleniumWithJava                         | title_selenium_with_java            | result_list                                                                                            |
      | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | https://www.seleniumeasy.com/selenium-tutorials | Selenium Tutorials \| Selenium Easy | aa ; bb ; a@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |
      | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | https://www.seleniumeasy.com/selenium-tutorials | Selenium Tutorials \| Selenium Easy |cc ; dd ; b@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |