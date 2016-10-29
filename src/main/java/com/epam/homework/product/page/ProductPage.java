package com.epam.homework.product.page;

import com.epam.homework.framework.browser.Browser;
import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {
    private static final By ADD_TO_CART_LINK_LOCATOR = By.xpath("//a[@id='j-add-cart-btn']");
    private static final By ADD_TO_CARD_REPORT_WINDOW_LOCATOR = By.xpath("//div[contains(@class,'ui-window-bd')]");
    private static final By PRODUCT_HEADER_LOCATOR = By.xpath("//h1[contains(@class, 'product-name')]");
    private static final By ADDITIONAL_PROPERTIES_LIST_LOCATOR = By.xpath("//ul[contains(@id,'j-sku')]");
    private static final By CONCRETE_ADDITIONAL_PROPERTY_LINK_LOCATOR = By.xpath(".//li//a");
    private static final By ADD_TO_CARD_REPORT_WINDOW_GO_TO_CART_BUTTON_LOCATOR =
            By.xpath("//div[contains(@class,'ui-window-bd')]//div[@data-role='buttons']/a");

    private static final Element ADD_TO_CART_BUTTON = new Element(ADD_TO_CART_LINK_LOCATOR);
    private static final Element PRODUCT_HEADER = new Element(PRODUCT_HEADER_LOCATOR);
    private static final Element ADDITIONAL_PROPERTIES_LIST = new Element(ADDITIONAL_PROPERTIES_LIST_LOCATOR);
    private static final Element ADD_TO_CARD_REPORT_WINDOW = new Element(ADD_TO_CARD_REPORT_WINDOW_LOCATOR);
    private static final Element ADD_TO_CARD_REPORT_WINDOW_GO_TO_CART_BUTTON =
            new Element(ADD_TO_CARD_REPORT_WINDOW_GO_TO_CART_BUTTON_LOCATOR);

    public void addToCart() {
        if (ADDITIONAL_PROPERTIES_LIST.isPresent()) {
            setAdditionalProperties();
        }
        ADD_TO_CART_BUTTON.waitAndClick();
    }

    private void setAdditionalProperties() {
        List<WebElement> elementList = Browser.getBrowser().findElements(ADDITIONAL_PROPERTIES_LIST_LOCATOR);
        for (WebElement element : elementList) {
            element.findElement(CONCRETE_ADDITIONAL_PROPERTY_LINK_LOCATOR).click();
        }
    }

    public boolean isAddToCardReportWindowDisplayed() {
        return ADD_TO_CARD_REPORT_WINDOW.isVisible();
    }

    public CartPage goToCartByReportWindowButton() {
        ADD_TO_CARD_REPORT_WINDOW_GO_TO_CART_BUTTON.click();
        return new CartPage();
    }

    public boolean isHeaderPresent() {
        return PRODUCT_HEADER.isPresent();
    }

    public String getHeader() {
        return PRODUCT_HEADER.getText().trim();
    }
}

