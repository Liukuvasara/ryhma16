Feature: As a user I want to add a book

    Scenario: Book is intialized correctly
        Given Book is initialized with title "Testi" and author "Testinen" and page count 77
        Then the title should be "Testi"
        And  the author should be "Testinen"
        And  the pagecount should be 77

