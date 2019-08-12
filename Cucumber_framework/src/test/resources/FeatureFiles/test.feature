@document
Feature: Identify the working document links in the developer web page

  Scenario: Verify that all the links are working related document page
    Given I am on the Home Page "https://developer.here.com" of developer hear Website
    When I click the document link in the developer hear Website
    Then the "Documentation" page should be loaded
    And I get all the linkes related to "document"
    Then all the links should be working and status code should be "200"
