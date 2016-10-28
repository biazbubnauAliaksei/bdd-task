package com.epam.homework.product.page;

import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;

public class CartPage {
    private static final By REMOVE_LINK_LOCATOR = By.xpath("//a[contains(@class,'remove-single-product')]");
    private static final By PRODUCT_ATTR_CONTAINING_ELEMENTS_LOCATOR = By.xpath("//div[contains(@class,'item-group-wrapper')]");

    private static final Element REMOVE_LINK = new Element(REMOVE_LINK_LOCATOR);

    public void remove() {
        REMOVE_LINK.waitAndClick();
    }

    public boolean isContainsProduct(String header) {

    }
}
