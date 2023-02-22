Feature: Welcome Page

  @UI
    @DB
  Scenario Outline: As a user, after entering valid information, I should be able to perform various actions in the Welcome Page
    Given delete used promocode
    Given User login as Buyer
    And Cart i bosalt
    And Add some product to cart
    And User goes to cart page
    Then Enter promo code menu should be functional
    When Code enter in the Enter "<promo_code>" menu
    And Click the Apply button.
    Then assert toast message "<toastMessage>" if it is "<valid>"
    Then After the code is entered, the code rate should give results has "<type>" and amount is <amount> .

#    And Prome code must not be greater than or equal to the total amount
#    And After entering the promecode that is greater than or equal to the total amount, the alert should appear.
#    And Alert: You can't apply this promecode due to greater or equal than your total amount
#    And Post payment promecode should show correct result
#    And Undefined promecode cannot be entered
#    And Undefined promecode code soner Invalid Prome-Code. No such prome code is defined. alert should appear

    Then proceed from the Proceed to checkout button and complete the payment.

    Examples: promocode test data
      | promo_code                      | type       | amount | toastMessage                                     | valid |
      | dolar10                         | money      | 10     |                                                  | true  |
      | percentage10                    | percentage | 10     |                                                  | true  |
      | ufuruktenTeyyareSelamSoyleOYare | money      | 0      | Invalid Promo-code.No such promo code is defined | false |



















