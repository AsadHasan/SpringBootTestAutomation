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

  Scenario Outline:  Shop by sub-department
    When I select a product <category>
    Then I am presented with <sub-department> titles
    And list of <categories> within that <sub-department>

    Examples:
      | category                  | sub-department       | categories                                                                            |
      | Kitchen & Home Appliances | VACUUMS & FLOOR CARE | Upright Vacuums, Handheld Vacuums, Robotic Vacuums, Carpet Washers, Steam Cleaners |
