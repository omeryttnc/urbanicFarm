Feature: Login

  @buyer
  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 1
    Given tag kullanarak


  @UI
  Scenario Outline: is user able to login version 2

    Given Scenario Outline "<username>" and "<password>"
    Examples: user info lari
      | username                 | password        |
      | buyer_urban@mailsac.com  | VHt*zzt*wQNu6XS |
      | seller_urban@mailsac.com | VHt*zzt*wQNu6XS |


  @UI
  Scenario: is user able to login version 3
    Given Configuration properties kullanarak


  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 4
    Given Data table kullanarak
      | buyer_urban@mailsac.com  | VHt*zzt*wQNu6XS |
      | seller_urban@mailsac.com | VHt*zzt*wQNu6XS |


  @UI
  @omer
  @smoke
  @login
  Scenario: is user able to login version 5
    Given Scenario icinde "buyer_urban@mailsac.com" and "VHt*zzt*wQNu6XS"



