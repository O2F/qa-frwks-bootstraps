
//Correctly this should use page-objects but it is a simple example 

import {
    Given,
    When,
    And,
    Then,
  } from "@badeball/cypress-cucumber-preprocessor";

/// <reference types="cypress" />

Given("the user navigates to the initial page", () => {
    cy.visit("https://alapanme.github.io/testing-cypress.html")
})

When("he clicks the try it button",() => {
    cy.window().then((win) => {
        cy.stub(win, 'open').callsFake(() => {
            win.location.href = 'https://the-internet.herokuapp.com/';
        }).as("popup")
    })
    cy.get('button').click()
})

Then("a second window is displayed", () => {
    cy.get('@popup')
            .should("be.called")
})

And("The message {string} is displayed", (stmt) =>{
    cy.get('h1')
            .should('have.text', stmt)
})