Feature: Login with parameters

  @librarianParam
  Scenario: Login as librarian 13
    Given I am on the login page
    When I enter username "librarian13@library"
    And I enter password '9rf6axdD'
    And click the sign in button
    And there should be 5566 users
    Then dashboard should be displayed
      #number can be whatever you have there

  @studentParam
  Scenario: Login as student 30
    Given I am on the login page
    When I enter username "student30@library"
    And I enter password 'IaT9YI0I'
    And click the sign in button
    Then books should be displayed
      #number can be whatever you have there

@StudentAndLibrarian
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian13@library" and "9rf6axdD"
    Then dashboard should be displayed