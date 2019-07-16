@tag
Feature: Login - User
  Check login functionality for user role

  @tag1
  Scenario: User can login succesfully to the website
    Given User is at homepage
    When User is logged in with email "" and password ""
    Then User can see account profile page

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
