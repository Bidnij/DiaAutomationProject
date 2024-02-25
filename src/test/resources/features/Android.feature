Feature: Android scenarios

  @regression
  Scenario Outline: Selecting bank and back
    Given I see landing screen
    And I tap bankId button
    Then I see bank select screen
    And I tap on bank with name <bankName>
    And I tap back button
    Then I see bank select screen
    Examples:
    | bankName      |
    | РадаБанк      |
    | sportbank     |
    | Полтава-банк  |

  @regression
  Scenario: Checking the application after locking and after unlocking the screen
    Given I see landing screen
    When I lock device screen
    And I see device lock status is on
    And I unlock device screen
    Then I see device lock status is off

  @regression
  Scenario: Checking the application after hiding and after unhide
    Given I see landing screen
    When I hide application to background and back
    And I tap bankId button
    Then I see bank select screen

  @regression
  Scenario: Checking the application after turnOff internet connection
    Given I see landing screen
    When I turnOff Network connection
    And I tap bankId button
    Then I see no internet connection popup

#  @regression // Screen rotation cannot be changed to ROTATION_270 after 2000ms. Is it locked programmatically? (Doesn't work for DIA)
  Scenario: Trying move application to landscape mode
    Given I see landing screen
    When I rotate screen to landscape