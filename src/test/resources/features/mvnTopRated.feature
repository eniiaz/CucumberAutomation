Feature: Popular tools MVN Repository

  Scenario: Verifying the top rated tools on mvn repository
    Given user is on mvnrepository application
    When user clicks on popular link
    Then user should see tools listed from top rated to less rated