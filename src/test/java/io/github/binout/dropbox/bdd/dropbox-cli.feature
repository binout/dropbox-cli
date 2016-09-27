Feature: Features of dropbox command line

  Scenario: Command whoami
    Given a dropbox api key
    When i type "whoami"
    Then it should return my name

  Scenario: Command ls
    Given a dropbox api key
    When i type "ls"
    Then it should return a list of path