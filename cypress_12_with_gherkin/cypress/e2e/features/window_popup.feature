Feature: Window popup on click

    Simple evaluation that when the button of the first window is clicked another window appears

Scenario: Validate that second window appear on button click in first window
    Given the user navigates to the initial page
    When he clicks the try it button
    Then a second window is displayed
    And The message "Welcome to the-internet" is displayed