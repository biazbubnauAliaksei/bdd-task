package com.epam.homework.product.page;

import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;

public class MainPage {
    private static final String CONCRETE_CATEGORY_LOCATOR_PATTERN =
            "//div[contains(@class, 'categories-list-box')]//span[text()='%s']";
    private static final String CONCRETE_SUBCATEGORY_LOCATOR_PATTERN = "//a[text()='%s']";
    private static final By STARTING_WINDOW_CLOSE_BUTTON_LOCATOR =
            By.xpath("//div[contains(@class, 'ui-window-content')]/a");

    private static final Element STARTING_WINDOW_CLOSE_BUTTON_ELEMENT = new Element(STARTING_WINDOW_CLOSE_BUTTON_LOCATOR);

    public MainPage selectCategory(String category) {
        Element categoryElement = new Element(makeLocator(CONCRETE_CATEGORY_LOCATOR_PATTERN, category));
        categoryElement.cursorLocateOn();
        return this;
    }

    public MainPage handleStartingWindow() {
        if (STARTING_WINDOW_CLOSE_BUTTON_ELEMENT.isPresent()) {
            STARTING_WINDOW_CLOSE_BUTTON_ELEMENT.click();
        }
        return this;
    }

    public CategoryPage clickCategory(String category) {
        Element subCategoryElement = new Element(makeLocator(CONCRETE_SUBCATEGORY_LOCATOR_PATTERN, category));
        subCategoryElement.waitAndClick();
        return new CategoryPage();
    }

    private By makeLocator(String pattern, String value) {
        String locator = String.format(pattern, value);
        return  By.xpath(locator);
    }
}
