Feature: Verifying OMR Branch hotel Cancel Booking

  @CancelBook
  Scenario Outline: To Validate Cancel booking
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User cancel the order id
    Then User should verify the success message after cancel "Your booking cancelled successfully"

    Examples: 
      | username                 | password     |
      | ananthpriyanan@gmail.com | Kavinila@123 |
