@tag
Feature: AbhiBus Automation
  I want to test the Abhibus web site

  Background: User enter <from city> and <To city>
    
    | from city | To city |
    | Bangalore | Chennai |


  @Bus-Booking @FunctionalTests
  Scenario: Bus Ticket Booking
    Given I want to open the AbhiBus Website
#    And user login the abhibus website with "username" and "password" credentials
    When user enter the from city and to city
    And user enter the date of journey
    And user click on the search button
    Then user will see the buss list and choose what you want
    And user will pick the seat

  @Train-Booking @FunctionalTest
  Scenario: Train Ticket Booking
    Given Open the AbhiBus train booking website
    And user enter the <from station> and <to station>
    And user select the date
    And click on the search button
    And User select the train in the list of train
     

   @flight-Booking
   Scenario: flight Ticket Booking
#   Given Open the AbhiBus booking
#      And user click on the flight booking
     And user click on the "Flight" booking
     And user enter the <from station> and <to station>
     And user select the date
     And click on the search button

