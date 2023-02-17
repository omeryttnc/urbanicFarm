#Delivery type-Seller flexible delivery
#All menus in the relevant area should be functional and appropriate options should be selected.
#Free Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#Minimum Order Amount For Free Delivery($) should be 0-10000. Alert should be seen on different selections
#Per Mile Cost ($) should be 0-5. Alert should be seen in different selections
#Maximum Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#A suitable day must be selected for the Order Begin menu.
#Time menu should work correctly
#A suitable day must be selected for the Order End menu.
#Time menu should work correctly
#A suitable day must be selected for the Deliver By menu
#Time menu should work correctly
#Your delivery settings have been succesfully updated alert should appear

#  1. functionality ve visibility
#2. inputlar
#  3. time day

@UI
Feature:

  Background:
    Given User login as Seller
    When user clicks on user name
    And user clicks on delivery and pickup settings
    And user clicks on seller flexible

  Scenario: TC001 - visibility & functionality
    Then user verifies web elements with following ids are visible
      | freeFlexibleDeliveryRange | minFreeFlexibleDeliveryOrder | perMileCostFlex | maxFlexibleDeliveryRange | _deliveryBeginDay | _deliveryBeginTime | _deliveryEndDay | _deliveryEndTime | _orderByDay | _orderByTime |
    And user verifies web elements with following ids are clickable
      | freeFlexibleDeliveryRange    |
      | minFreeFlexibleDeliveryOrder |
      | perMileCostFlex              |
      | maxFlexibleDeliveryRange     |
      | _deliveryBeginDay            |
      | _deliveryBeginTime           |
      | _deliveryEndDay              |
      | _deliveryEndTime             |
      | _orderByDay                  |
      | _orderByTime                 |

  Scenario: TC002 - inputs
    When user enters number to free delivery range and asserts border color and alerts
      | -1        | rgba(255, 0, 0, 0.25) | Value must be greater than or equal to 0. | 10 |
      | -0.00001  | rgba(255, 0, 0, 0.25) | Value must be greater than or equal to 0. | 10 |
      | 0         | rgba(206, 0, 0, 1)    | Please fill out this field.               |    |
      | 1         | rgba(206, 0, 0, 1)    | Please fill out this field.               |    |
      | 265       | rgba(206, 0, 0, 1)    | Please fill out this field.               |    |
      | 999       | rgba(206, 0, 0, 1)    | Please fill out this field.               |    |
      | 1000      | rgba(206, 0, 0, 1)    | Please fill out this field.               |    |
      | 1000.0001 | rgba(255, 0, 0, 0.25) | Value must be less than or equal to 1000. | 10 |
      | 1001      | rgba(255, 0, 0, 0.25) | Value must be less than or equal to 1000. | 10 |

  Scenario Outline: TC003 - time day
    When user selects "<orderBegin>" for orderBegin
    And user enters input to order begin "<beginTime>"
    And user selects "<orderEnd>" for orderEnd
    And user enters input to order end "<endTime>"
    And user selects "<deliverBy>" for deliverBy
    And user enters input to deliver by "<deliverTime>"
    And user clicks on update button
    Then user verifies the toast message is "<toastMessage>"
    Scenarios:
      | orderBegin | beginTime | orderEnd | endTime | deliverBy | deliverTime | toastMessage                                                                     |
      | 6          | 0205pm    | 3        | 0306pm  | 2         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 3          | 0205pm    | 3        | 0205am  | 2         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 3          | 0205pm    | 6        | 0306pm  | 2         | 0306pm      | Your delivery settings have been successfully updated                            |

