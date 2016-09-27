Feature: Features of dropbox command line

  ====
  [quote]
  ____
  In order to manage my Dropbox account,
  As a Dropbox user
  I want to use a CLI.
  ____
  ====

  [IMPORTANT]
  =====
  You need to retrieve a API key for https://dropbox.github.io/dropbox-api-v2-explorer[Dropbox API v2]
  =====

  Scenario: Command whoami
    Given a dropbox api key
    When i type "whoami"
    Then it should return my name

  Scenario: Command ls
    Given a dropbox api key
    When i type "ls"
    Then it should return a list of path