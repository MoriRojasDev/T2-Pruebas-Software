package edu.pe.cibertec.saucedemo.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {
    public static final Target FIRST_NAME = Target.the("first name field")
            .locatedBy("#first-name");

    public static final Target LAST_NAME = Target.the("last name field")
            .locatedBy("#last-name");

    public static final Target POSTAL_CODE = Target.the("postal code field")
            .locatedBy("#postal-code");

    public static final Target CONTINUE_BUTTON = Target.the("continue button")
            .locatedBy("#continue");

    public static final Target ITEM_TOTAL = Target.the("item total")
            .locatedBy(".summary_subtotal_label");

    public static final Target FINISH_BUTTON = Target.the("finish button")
            .locatedBy("#finish");

    public static final Target CONFIRMATION_MESSAGE = Target.the("confirmation message")
            .locatedBy(".complete-header");

    public static final Target ERROR_MESSAGE = Target.the("error message")
            .locatedBy("h3[data-test='error']");

    public static Target CHECKOUT_FORM = Target.the("checkout form")
            .located(By.id("checkout_info_container"));

}