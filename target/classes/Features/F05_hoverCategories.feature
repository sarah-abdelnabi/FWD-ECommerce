@smoke

Feature: F05_hoverCategories | User hover on random Category and clicks on it

  Scenario: Logged user could select different Categories
    Given user has logged in
    And   user is at home page
    When  user hovers over any random category
    And   user clicks sub-category if found
    Then  page title should contain category or sub-category name