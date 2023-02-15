Business Need: Your products/services
  Rule: keyword is to represent one business rule that should be implemented
  is used to group together several scenarios that belong to this business rule
  should contain one or more scenarios that illustrate the particular rule.
    @UI
    @DB
    Scenario: As a user, after entering valid information, I should be able to perform various actions in the Your products/services section
      Given User login as Seller
      And User goes to Your products-services
      And User click on random Hubs
      When Product Name, Price, Stock, Unit information added products should be displayed.
      Then One of the Approved, In-Review, Rejected options for each product should be visible on the file.
      Then In-Review should be visible on the added product.
      Then User approve last added product from database
      Then Approved should be visible on the added product.
      Then It should be possible to click on the product name on the file related to the previously added product.
      When The product name is clicked, the update-delete page is displayed.
      When Product information should be able to be changed on this page
      When the update option is clicked after the necessary corrections, (.....) has been succesfully updated alert should be displayed.
      When the Delete button is clicked, yes- no options should appear.
      Then Yes-No options should appear.
      When One of the Yes-No options should be selected.
      Then No option should cancel the operation
      When Yes option is selected, the product should be removed from the page.




  Rule: another implementation