Feature: Verifying OMR Branch hotel ExploreHotel page

  @AllFieldsExplore
  Scenario Outline: Enter all fields and verify select Hotel(Including Options)
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @MultipleRoom
  Scenario Outline: To Validate Explore hotel page Select multiple roomtype and verify selected rooms are displayed
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User should verify success message after search hotel all roomtypes are displayed "<roomtype>"

    Examples: 
      | username                 | password     | state      | city    | roomtype            | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe/Suite/Luxury | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @EndsWith
  Scenario Outline: To Validate Explore hotel page by passing roomtype and verify hotel names are end with same roomtype
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User should verify after search hotel all hotel name ends with "Deluxe"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @SixErrorMessage
  Scenario Outline: To Validate Explore hotel page Without enter any field search and verify all 6 error message
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform search without entering any data
    Then User should verify error messages displayed in six fields "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms","Please select no. of adults"

    Examples: 
      | username                 | password     |
      | ananthpriyanan@gmail.com | Kavinila@123 |

  @Multipleroomcheck
  Scenario Outline: Verify Explore hotel page Select multiple roomtype and selected rooms are displayed
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<roomtype2>","<roomtype3>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User should verify success message after search hotel all roomtypes are displayed "Deluxe/Suite/Luxury"

    Examples: 
      | username                 | password     | state      | city    | roomtype | roomtype2 | roomtype3 | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | Suite     | Luxury    | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |
