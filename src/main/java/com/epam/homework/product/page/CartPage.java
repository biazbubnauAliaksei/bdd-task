package com.epam.homework.product.page;

import com.epam.homework.framework.browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private static final By RELATED_REMOVE_LINK_LOCATOR =
            By.xpath("//ancestor::div[contains(@class,'item-group-wrapper')]"
                    + "//a[contains(@class,'remove-single-product')]");
    private static final By HEADER_CONTAING_ELEMENTS_LOCATOR = By.xpath("//a[contains(@class,'lnk-product-name')]");

    public void remove(String header) {
        List<WebElement> elements = getHeaderContainingElementsList();
        for (WebElement element : elements) {
            String text = element.getText();
            if (text.contains(header)) {
                element.findElement(RELATED_REMOVE_LINK_LOCATOR).click();
            }
        }
    }

    public boolean isContainsProduct(String header) {
        boolean result = false;
        List<WebElement> elements = getHeaderContainingElementsList();
        for (WebElement element : elements) {
            String text = element.getText();
            if (text.contains(header)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private List<WebElement> getHeaderContainingElementsList() {
        return Browser.getBrowser().findElements(HEADER_CONTAING_ELEMENTS_LOCATOR);
    }

}
