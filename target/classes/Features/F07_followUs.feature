@smoke

Feature: Follow us on social media

  Background:
    Given user go to home page

  Scenario: User could follow us on facebook
    When  clicks on facebook link
    And   user switches to new tab
    Then  page url should be "https://www.facebook.com/nopCommerce"

  Scenario: User could follow us on twitter
    When  clicks on twitter link
    And   user switches to new tab
    Then  page url should be "https://twitter.com/nopCommerce"

  Scenario: User could follow us on rss
    When  clicks on rss link
    And   user switches to new tab
    Then  page url should be "https://demo.nopcommerce.com/new-online-store-is-open"

  Scenario: User could follow us on youtube
    When  clicks on youtube link
    And   user switches to new tab
    Then  page url should be "https://www.youtube.com/user/nopCommerce"