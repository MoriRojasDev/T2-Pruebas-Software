package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import net.serenitybdd.screenplay.playwright.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {

    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );
    }

    @Then("she should be redirect to the inventory page")
    public void sheShouldBeRedirectToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(InventoryPage.PAGE_TITLE), equalTo("Products"))
        );
    }

    @And("she should see the page title {string}")
    public void sheShouldSeePageTitle(String titulo) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(InventoryPage.PAGE_TITLE), equalTo(titulo))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

    }

}
