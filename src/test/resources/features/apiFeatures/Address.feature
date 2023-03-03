Feature:

#  @ezra
  Scenario:
    Given user logs in with api
    Then user gets address info
    When user adds an address
    Then user gets address info
    And user verifies added address exists
    When user updates the address
    Then user verifies the status code is 200
    Then user verifies the response
      #    expected - actual
      | Address updated | descr           |
#      | Hi hel        | address.address |
    And user deletes the address
