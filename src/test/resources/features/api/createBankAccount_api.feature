Feature: Bank Account Creation

  #User Story: CAS-56

  Scenario Outline: Creating bank account - Positive
    Given user hits create bank account API with "<path>" "<bank type>" "<bank title>" "<description>" "<balance>"
    Then user verifies that bank account is successfully created

    Examples:
      | path                       | bank type                 | bank title | description | balance |
      | /api/myaccount/bankaccount | BANK                      | BoA        | test desc   | 1000    |
      | /api/myaccount/bankaccount | CASH                      | Chase      | test desc   | -100    |
      | /api/myaccount/bankaccount | ELECTRONIC_MONEY_TRANSFER | Optima     | test desc   | 10000   |


  Scenario: Creating bank account - Security verification
    Given user hits bank account creation API without token with  "/api/myaccount/bankaccount" "BANK" "Some bank" "no token" "200"
    Then user verifies the status code to be "403"
