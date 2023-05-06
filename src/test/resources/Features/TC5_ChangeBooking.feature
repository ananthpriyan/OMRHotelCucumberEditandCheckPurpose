Feature: Verifying OMR Branch hotel Change Booking
@ChangeBooking
  Scenario Outline: To Validate Change booking and verify success message
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and accept the alert
    Then User should verify success message after selecting hotel "Book Hotel"
    When User add guest details "<select salutation>","<firstname>","<lastname>","<mobilenumber>" and "<email>"
    And User enters payment details proceed with card type "<card_type>"
      | selectcardtype | entercardnum     | enternameoncard | selectmonth | selectyear | cardcvv |
      | Visa           | 5555555555552223 | Ananth          | June        |       2028 |     453 |
      | Mastercard     | 5555555555552224 | Ananth          | July        |       2030 |     675 |
      | Amex           | 5555555555552225 | Ananth          | March       |       2034 |     478 |
      | Discover       | 5555555555552226 | Ananth          | April       |       2024 |     987 |
    Then User should verify after book hotel confirmation message "Booking is Confirmed" and save the order id
    And User should verify whether selected hotel is booked
    When User navigate into my bookings and search order id 
    Then User should verify order id and hotel name are same
    And User change the booking "<Check in>"
    Then User should verify the success message after update "Booking updated successfully"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs | select salutation | firstname | lastname | mobilenumber | email                   | card_type   | Check in   |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 | Mr.               | Ananth    | Anbu     |   9003845731 | ananthprianan@gmail.com | Credit Card | 2023-04-24 |
