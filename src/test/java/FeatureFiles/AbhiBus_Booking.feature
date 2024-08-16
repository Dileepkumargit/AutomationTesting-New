Feature: Abhi Bus Ticket Booking

  User able open the AbhiBus and Booke the tickets in Bus, Train and flight etc.

  Background:
    Given user enter the AbhiBus Website

  @Bus-Booking
  Scenario: AbhiBus Ticket Booking

    Then user enter the "Bangalore" and "chennai"
    And Click on the search
    And User select the BusType
    And User select the Bus from the list and select the seat

  @flight-Booking
  Scenario: AbhiBus Flight Booking Testing

    When user select the "Flight" Operator type
    Then user enter the from location "Bangalore" and to location "delhi"

