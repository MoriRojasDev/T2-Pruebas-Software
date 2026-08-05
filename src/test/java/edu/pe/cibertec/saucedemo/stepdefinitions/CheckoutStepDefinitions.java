package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.questions.Text;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.conDatos(firstName, lastName, postalCode)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesOrderSummary(String total) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerificarResumen.itemTotal(), containsString(total))
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeConfirmationMessage(String message) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(String.valueOf(CheckoutPage.CONFIRMATION_MESSAGE)), equalTo(message))
        );
    }

    @Then("she should see the error message {string}")
    public void sheShouldSeeErrorMessage(String error) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(String.valueOf(CheckoutPage.ERROR_MESSAGE)), equalTo(error))
        );
    }

    @And("the checkout form should remain visible")
    public void checkoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(String.valueOf(CheckoutPage.CHECKOUT_FORM)), equalTo(true))
        );
    }

}