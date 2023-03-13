Feature: Event E2E

  Scenario: event e2e
    Then user create an event from backend
    Then assert if event is created from backend
    Then user update an event from backend
    Then user cancel an event from backend
    Then user delete an event from backend
    Then assert if event is deleted from backend

