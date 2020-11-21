Feature: As a user I want to add a book

    Scenario: Kirjan nimi
        Given Book is initialized
        Then the title should be "Testi"

    Scenario: Kirjan tekijä
        Given Book is initialized
        Then the author should be "Testinen"


    Scenario: Pagecount
        Given Book is initialized
        Then the pagecount should be 77
