Feature: Search products on Amazon
  As a user
  I want to be able to search for products and filter them
  So that I can easily find products for purchase

  Background:
    Given I am on the homepage

  Scenario Outline: Search for product and filter by price
    When I search for <product> in <department>
    And I filter results by <category> and <price>
    Then only results with <category> and <price> are shown

    Examples:
      | product                      | department              | category | price       |
      | Microsoft Surface Pro Tablet | Computers & Accessories | Tablet   | £200 - £500 |