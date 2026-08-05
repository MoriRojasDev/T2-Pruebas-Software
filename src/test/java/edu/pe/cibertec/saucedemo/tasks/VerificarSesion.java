package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class VerificarSesion implements Task {

    public static Task irAlCarrito() {
        return Tasks.instrumented(VerificarSesion.class, "cart");
    }

    public static Task irAlInventario() {
        return Tasks.instrumented(VerificarSesion.class, "inventory");
    }

    public static Question<Boolean> sesionActiva() {
        return actor -> Text.of(InventoryPage.PAGE_TITLE).answeredBy(actor).equals("Products");
    }

    public static Question<Integer> tiempoDeCarga() {
        return actor -> {
            // Aquí puedes medir el tiempo de carga con Playwright
            // Ejemplo simplificado: devolver un valor simulado
            return 3500; // ms
        };
    }

    private final String destino;

    public VerificarSesion(String destino) {
        this.destino = destino;
    }

    public static VerificarSesion hacia(String destino) {
        return Tasks.instrumented(VerificarSesion.class, destino);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if ("cart".equals(destino)) {
            actor.attemptsTo(Click.on(CarritoPage.CART_LINK));
        } else if ("inventory".equals(destino)) {
            actor.attemptsTo(Click.on(InventoryPage.INVENTORY_LINK));
        }
    }
}
