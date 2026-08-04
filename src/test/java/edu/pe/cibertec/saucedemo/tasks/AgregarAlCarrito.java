package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgregarAlCarrito implements Task {

    private final String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    public static AgregarAlCarrito de(String producto) {
        return Tasks.instrumented(AgregarAlCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Formatea el nombre del producto para convertirlo al formato de ID de SauceDemo
        // Ejemplo: "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack"
        String idProducto = "add-to-cart-" + producto.toLowerCase().replace(" ", "-");

        Target BOTON_AGREGAR = Target.the("botón agregar " + producto)
                .located(By.id(idProducto));

        actor.attemptsTo(
                Click.on(BOTON_AGREGAR)
        );
    }
}

