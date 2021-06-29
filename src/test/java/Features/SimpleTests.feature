Feature: Test selenium partial test
    @SmokeTest
    # The first example has several steps
    Scenario Outline: "<test_number>" : Go to website and send form data
    Given User is on "<webPage>" page
    When I am on the "<webPage>" page
    Then the page title should be "<title_main>"
    Then user go to test page by clicking button Demo Website
    Then click on root element
    Then click on form submit element
    Then fill forms with data "<result_list>" and submit
    Examples:
        | test_number | webPage                       | title_main                                                       | result_list                                                                                            |
        |     1       | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | aa ; bb ; a@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |
        |     2       | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | cc ; dd ; b@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |

    @RegressionTest
    # The second example has several steps
    Scenario Outline: "<test_number>" : Go to website and open "<article_number>" article
        Given User is on "<webPage>" page
        When I am on the "<webPage>" page
        Then the page title should be "<title_main>"
        When user go to selenium with java page
        Then page and title should be "<webpageSeleniumWithJava>" "<title_selenium_with_java>"
        Then user opens "<article_number>" on page
        Examples:
            | test_number | webPage                       | title_main                                                       | webpageSeleniumWithJava                         | title_selenium_with_java            | article_number |
            |     1       | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | https://www.seleniumeasy.com/selenium-tutorials | Selenium Tutorials \| Selenium Easy | 1              |
            |     2       | https://www.seleniumeasy.com/ | Learn Selenium with Best Practices and Examples \| Selenium Easy | https://www.seleniumeasy.com/selenium-tutorials | Selenium Tutorials \| Selenium Easy | 3              |