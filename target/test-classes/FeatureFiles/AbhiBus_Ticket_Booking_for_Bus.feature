@tag
Feature: AbhiBus Automation
  I want to test the Abhibus web site

  Background: User enter <from city> and <destination city>
    
    | from city | destination city |
    | Bangalore | Chennai |


  @Bus-Booking @FunctionalTests
  Scenario: Bus Ticket Booking
    Given I want to open the AbhiBus Website
    And user login the abhibus website with "username" and "password" credentials
    When user enter the from city and distination city
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
    And select the train in the list
    | from Station | to Station |
    | Bangalore    | Chennai    |
     
      
      
      
   #flight-Booking
   #Scenario: Train Ticket Booking
   #Given Open the AbhiBus
   #And user enter the from station and to station
   #And user select the date
   #And click on the search button 
   #And select the flight in the list
