Feature: Abhi Bus Ticket Booking

  User able open the AbhiBus and Booke the tickets in Bus, Train and flight etc.

  Scenario Outline: AbhiBus Ticket Booking

    Given user enter the AbhiBus Website
    When user select the Operator type
    Then user enter the "Bangalore" and "chennai"
    And Click on the search
    And User select the BusType
    And User select the Bus from the list and select the seat

    Examples:
      | from station | to station |
      | Bangalore    | Chennai    |
