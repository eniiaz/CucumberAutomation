Feature: MVN Repository Indexed Artifact

  Scenario: Verifying the result for Indexed Artifacts
    Given user is on mvnrepository application
    When user clicks on indexed artifacts menu
    Then user should see header "Top 20 repositories"
    And user should see "20" repositories in the result