Feature: Verifying OMR Branch hotel Select Hotel page

  @Selectaccept
  Scenario Outline: To Validate Select hotel page and verify navigate to book hotel upon accepting the alert
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and accept the alert
    Then User should verify success message after selecting hotel "Book Hotel"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @Dismissalert
  Scenario Outline: To Validate Select hotel page and navigate to book hotel upon dismiss the alert
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    And User select the first hotel name and save the selected hotel name
    When User perform continue and dismiss the alert
    Then User should verify success message after selecting hotel "Book Hotel"

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @AscendingHotelName
  Scenario Outline: To Validate select hotel page Sort Hotel name in ascending order
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    When User clicks Name ascending filter button
    Then User should verify hotel names are displayed in ascending order

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  Scenario Outline: To Validate select hotel page by unselecting roomtype and all hotels are listed
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    When User unselecting roomtype by unselecting filter button
    Then User should verify all hotels are listed

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @AscendingHotelPrice
  Scenario Outline: To Validate select hotel page Sort Hotel price in ascending order
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    When User clicks prize low to high ascending filter button
    Then User should verify hotel prize are displayed in ascending order

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |

  @DescendingHotelPrice
  Scenario Outline: To Validate select hotel page Sort Hotel price in Descending order
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"
    And User perform "<state>","<city>","<roomtype>","<checkin>","<checkout>","<Numofrooms>","<adults>" and "<childs>"
    Then User should verify success message after search hotel "Select Hotel"
    When User clicks prize high to low descending filter button
    Then User should verify hotel prize are displayed in descending order

    Examples: 
      | username                 | password     | state      | city    | roomtype | checkin    | checkout   | Numofrooms | adults | childs |
      | ananthpriyanan@gmail.com | Kavinila@123 | Tamil Nadu | Chennai | Deluxe   | 2023-04-19 | 2023-05-25 | 2-Two      | 2-Two  |      2 |
