Feature: Demo Blaze Login

  @data
  Scenario: Verifying the login functionality positive
    Given user is on demo blaze application
    And user clicks on login button for demo blaze
    When user enters credentials "codewise" and "test" and clicks login
    Then user should successfully login to application