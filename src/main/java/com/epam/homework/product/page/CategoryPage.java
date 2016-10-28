package com.epam.homework.product.page;

import com.epam.homework.framework.browser.Browser;
import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CategoryPage {
    private static final By SELECTED_BRAND_ELEMENT_LOCATOR =
            By.xpath("//div[@id='brands-wall-content']/ul/li[contains(@class,'selected')]/a");
    private static final By BRAND_BUTTON_ELEMENTS_LOCATOR = By.xpath("//div[@id='brands-wall-content']/ul/li/a");
    private static final By CATEGORY_TITLE_CONTAINING_ELEMENT_LOCATOR =
            By.xpath("//div[@id='aliGlobalCrumb']/h1/span[last()]");
    private static final By FIRST_ITEM_IN_LIST_ELEMENT_LOCATOR = By.xpath("//ul[@id='list-items']/li[1]/a");
    private static final String TITLE_ATRR_NAME = "title";

    private static final Element TITLE_CONTAINING_ELEMENT = new Element(CATEGORY_TITLE_CONTAINING_ELEMENT_LOCATOR);
    private static final Element SELECTED_BRAND_ELEMENT = new Element(SELECTED_BRAND_ELEMENT_LOCATOR);
    private static final Element FIRST_ITEM_IN_LIST_ELEMENT = new Element(FIRST_ITEM_IN_LIST_ELEMENT_LOCATOR);

    public String getTitle() {
        return TITLE_CONTAINING_ELEMENT.getText();
    }

    public String getSelectedElementTitle() {
        return SELECTED_BRAND_ELEMENT.getWrappedWebElement().getAttribute(TITLE_ATRR_NAME);
    }

    public ConcreteProductPage selectFirstFoundProduct() {
        FIRST_ITEM_IN_LIST_ELEMENT.waitAndClick();
        return new ConcreteProductPage();
    }

    public CategoryPage clickConcreteBrand(String name) {
        List<WebElement> elements = Browser.getBrowser().findElements(BRAND_BUTTON_ELEMENTS_LOCATOR);
        for (WebElement element: elements) {
            if (element.getAttribute(TITLE_ATRR_NAME).equals(name)) {
                element.click();
                break;
            }
        } return this;
    }

    public ConcreteProductPage clickFirstItemFromList() {
        FIRST_ITEM_IN_LIST_ELEMENT.waitAndClick();
        return new ConcreteProductPage();
    }

}
