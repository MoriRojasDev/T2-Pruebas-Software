package edu.pe.cibertec.saucedemo.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {
    public static Target CART_ICON = Target.the("cart icon")
            .located(By.className("shopping_cart_badge"));

    public static Target CART_ITEMS = Target.the("cart items")
            .located(By.className("inventory_item_name"));
    public static Target CART_LINK;

    public static Target REMOVE_BUTTON(String producto) {
        return Target.the("remove button for " + producto)
                .located(By.xpath("//div[@class='inventory_item_name' and text()='" + producto + "']/ancestor::div[@class='cart_item']//button"));
    }
}