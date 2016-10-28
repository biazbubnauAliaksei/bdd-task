package com.epam.homework.product.page;

import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;

public class ProductPage {
    private static final By ADD_TO_CART_LINK_LOCATOR = By.xpath("//a[@id='j-add-cart-btn']");
    private static final By ADD_TO_CARD_REPORT_WINDOW_LOCATOR = By.xpath("");

    private static final Element ADD_TO_CART_BUTTON = new Element(ADD_TO_CART_LINK_LOCATOR);

    public void addToCart() {
        ADD_TO_CART_BUTTON.waitAndClick();
        //if message err - check and click element above
        //пока не появится сообщение о том, что добавилась хрень
    }

}
