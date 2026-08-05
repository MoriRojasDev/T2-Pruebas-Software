package edu.pe.cibertec.saucedemo.tasks;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class VerificarResumen {
    public static Question<String> itemTotal() {
        return actor -> Text.of(CheckoutPage.ITEM_TOTAL).answeredBy(actor);
    }
}

