Feature: Verifying OMR Branch hotel login page

  @Login
  Scenario Outline: Verifying login with valid credentials
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"

    Examples: 
      | username                 | password     |
      | ananthpriyanan@gmail.com | Kavinila@123 |

  Scenario Outline: Verifying login with Robot with help of Keyboard actions with valid credentials
    Given User is on OMR Branch hotel login page
    When User login using  keyboard actions "<username>","<password>"
    Then User should verify success message after login "Welcome Anandharaj"

    Examples: 
      | username                 | password     |
      | ananthpriyanan@gmail.com | Kavinila@123 |

  Scenario Outline: Verifying login with invalid credentials
    Given User is on OMR Branch hotel login page
    When User login "<username>","<password>"
    Then User should verify error message "User does not exist"

    Examples: 
      | username         | password |
      | ananth@gmail.com | nila@123 |
