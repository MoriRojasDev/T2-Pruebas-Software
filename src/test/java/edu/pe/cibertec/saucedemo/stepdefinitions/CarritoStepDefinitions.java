package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @And(" she adds the product \"Sauce Labs Backpack\" to the cart")
    public void sheAddsTheProductToTheCart(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.de(producto)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.de(producto)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String cantidad) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(CarritoPage.CART_ICON), equalTo(cantidad))
        );
    }

    @Then("the cart should contain {string} and {string}")
    public void theCartShouldContainTwoProducts(String producto1, String producto2) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.ofEach(CarritoPage.CART_ITEMS), hasItems(producto1, producto2))
        );
    }

    @Then("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String producto) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.ofEach(CarritoPage.CART_ITEMS), contains(producto))
        );
    }
}