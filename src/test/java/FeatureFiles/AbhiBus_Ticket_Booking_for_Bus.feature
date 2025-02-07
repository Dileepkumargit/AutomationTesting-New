@tag
Feature: AbhiBus Automation
  I want to test the Abhibus web site

  @Bus-Booking @FunctionalTest
  Scenario Outline: Bus Ticket Bookingb
    Given I want to open the AbhiBus Website
    And User enter "<fromCity>" and "<ToCity>"
    And user enter the date of journey
    And user click on the search button
    Then user will see the buss list and choose what you want
    And user will pick the seat

    Examples:
      | fromCity  | ToCity  |
      | Bangalore | Chennai |

  @Train-Booking @FunctionalTest
  Scenario Outline: Train Ticket Booking
    Given Open the AbhiBus train booking website
    And User enter "<fromCity>" and "<ToCity>"
    And user select the date
    And click on the search button
    And User select the train in the list of train

    Examples:
      | fromCity  | ToCity  |
      | Bangalore | Chennai |


   @flight-Booking @FunctionalTest
   Scenario Outline: flight Ticket Booking
     And user click on the "Flight" booking
     And User enter "<fromCity>" and "<ToCity>"
     And user enter the date of journey
     And click on the search button

     Examples:
       | fromCity  | ToCity  |
       | Bangalore | Chennai |


