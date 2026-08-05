package edu.pe.cibertec.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final String PAGE_TITLE = "[data-test='title']";
    public static final String ORDER_PRODUCT_SELECT = "[data-test='product-sort-container']";
    public static final String FIRST_ITEM_PRICE = "[data-test='inventory-item']:first-child [data-test='inventory-item-price']";
    public static final String LAST_ITEM_PRICE = "[data-test='inventory-item']:last-child [data-test='inventory-item-price']";
    // Lista general de productos
    public static final String PRODUCT_NAME = "[data-test='inventory-item-name']";
    public static final String PRODUCT_PRICE = "[data-test='inventory-item-price']";
    public static Target INVENTORY_LINK;


    public static  String itemNameLink (String productName){
        return  "text=" + productName;
    }

}
