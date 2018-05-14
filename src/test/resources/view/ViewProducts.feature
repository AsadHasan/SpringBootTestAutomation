Feature: View products on Amazon
  As a user
  In order to choose products for purchase
  I want to be able to view relevant products

  Background:
    Given I am on the homepage

  Scenario Outline: Shop by department
    When I try to shop by <department>
    Then I am presented with the available product <categories>

    Examples:
      | department               | categories                                         |
      | Home, Garden, Pets & DIY | Home & Garden; DIY, Tools & Home Improvement; Pets |
