Feature: User management

    Scenario: Retrieve administrator user
        When I search user 'admin@localhost'
        Then the user is found
        And his name is 'Administrator Administrator'
