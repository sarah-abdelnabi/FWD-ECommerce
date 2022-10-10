@smoke

Feature: F03_currencies | User Check Currency sign

  Scenario: User could change the currency
    Given user go to home page
    When  select Euro currency from the dropdown
    Then  Euro Symbol is shown on the 4 products displayed in Home page