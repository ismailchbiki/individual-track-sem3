//auto-completion from cypress library
/// <reference types="cypress" />

describe("Home Page Test", () => {
  //from mocha
  it("Clicks an element", () => {
    cy.visit("localhost:3000");

    cy.contains("Booking Site").click();
    cy.url().should("include", "/");

    cy.contains("Home").click();
    cy.url().should("include", "/");

    cy.contains("Book").click();
    cy.url().should("include", "/");

    cy.contains("Chatroom").click();
    cy.url().should("include", "/chatroom");

    cy.contains("Register").click();
    cy.url().should("include", "/register");

    cy.contains("Sign In").click();
    cy.url().should("include", "/login");
  });
});
