Feature: Test selenium easy website
    # The first example has 4 steps
    Scenario Outline: Go to website
    Given User is on "<webPage>" page
    When I am on the "<webPage>" page
    Then the page title should be "Learn Selenium with Best Practices and Examples | Selenium Easy"
    Then user go to test page by clicking button Demo Website
    Then click on root element
    Then click on form submit element
    Then fill forms with data "<result_list>" and submit
    Examples:
      | webPage                       | result_list |
      | https://www.seleniumeasy.com/ | aa ; bb ; a@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |
      | https://www.seleniumeasy.com/ | cc ; dd ; b@test.com ; 1923232323 ; test_address ; SaintP ; Alabama ; 19800 ; test project description |