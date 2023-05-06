Feature: Verifying OMR Branch hotel BookHotel page

  @BookHotelWithCreditCard
  Scenario Outline: To Validate Book hotel page without including GST - card(Credit card visa) -without special request
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
      | Mastercard     | 5555555555552223 | Ananth          | July        |       2030 |     675 |
      | Amex           | 5555555555552223 | Ananth          | March       |       2034 |     478 |
      | Discover       | 5555555555552223 | Ananth          | April       |       2024 |     987 |
    Then User should verify after book hotel confirmation message "Booking is Confirmed" and save the order id
    And User should verify whether selected hotel is booked

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs | select salutation | firstname | lastname | mobilenumber | email                   | card_type   |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 | Mr.               | Ananth    | Anbu     |   9003845731 | ananthprianan@gmail.com | Credit Card |

  @InvaldUPI
  Scenario Outline: To Validate Book hotel page by entering invalid UPI ID and verify error messages
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and accept the alert
    Then User should verify success message after selecting hotel "Book Hotel"
    When User add guest details "<select salutation>","<firstname>","<lastname>","<mobilenumber>" and "<email>"
    And User enter UPI ID "<upi id>"
    Then User should verify UPI error message "Invalid UPI ID"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs | select salutation | firstname | lastname | mobilenumber | email                   | upi id           |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 | Mr.               | Ananth    | Anbu     |   9003845731 | ananthprianan@gmail.com | ananth@icici.com |

  @InvalidCard
  Scenario Outline: To Validate Book hotel page by entering invalid card details and verify error message
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
      | Visa           | 7555555355552225 | Ananth          | June        |       2028 |     453 |
      | Mastercard     | 6555555455552226 | Ananth          | July        |       2030 |     675 |
      | Amex           | 8555555565552227 | Ananth          | March       |       2034 |     478 |
      | Discover       | 9555555559552228 | Ananth          | April       |       2024 |     987 |
    Then User should verify card error message "Invalid Card Details"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs | select salutation | firstname | lastname | mobilenumber | email                   | card_type   |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 | Mr.               | Ananth    | Anbu     |   9003845731 | ananthprianan@gmail.com | Credit Card |

  @BookHotelWithoutGuestDetailsErrorMsg
  Scenario Outline: To Validate Book hotel page without including GST - card(Credit card visa) -without special request
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and accept the alert
    Then User should verify success message after selecting hotel "Book Hotel"
    And User clicks next button without giving guest details
    Then User should verify all error message displayed "Let us know for whom you are booking the hotel","Please select Salutation of the user","Please provide First Name of the user","Please provide Last Name of the user","Please provide Contact Number of the user to ease the communication (if required)","Please provide Email ID of the user to ease the communication (if required)"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @BookHotelWithUpiId
  Scenario Outline: To Validate Book hotel page with including GST -with special request- UPI id
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and accept the alert
    Then User should verify success message after selecting hotel "Book Hotel"
    When User add guest details "<select salutation>","<firstname>","<lastname>","<mobilenumber>" and "<email>"
    And User enters GST details and any one Special request "<gstregisterNum>","<CompanyName>","<CompanyAdd>"
    And User enter UPI ID "<upi id>"
    Then User should verify after book hotel confirmation message "Booking is Confirmed" and save the order id
    And User should verify whether selected hotel is booked

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs | select salutation | firstname | lastname | mobilenumber | email                   | gstregisterNum | CompanyName            | CompanyAdd   | upi id               |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 | Mr.               | Ananth    | Anbu     |   9003845731 | ananthprianan@gmail.com |     9043592058 | Greens Tech OMR Branch | Thoraipakkam | seleniumtraining@vbc |
