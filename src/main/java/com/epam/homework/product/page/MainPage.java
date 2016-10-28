package com.epam.homework.product.page;

import com.epam.homework.framework.element.Element;
import org.openqa.selenium.By;

public class MainPage {
    private static final String CONCRETE_CATEGORY_LOCATOR_PATTERN =
            "//div[contains(@class, 'categories-list-box')]//span/a[text()='%s']";
    private static final String CONCRETE_SUBCATEGORY_LOCATOR_PATTERN = "//a[text()='%s']";

    public MainPage selectCategory(String category) {
        Element categoryElement = new Element(makeLocator(CONCRETE_CATEGORY_LOCATOR_PATTERN, category));
        categoryElement.cursorLocateOn();
        return this;
    }

    public ConcreteCategoryPage clickCategory(String category) {
        Element subCategoryElement = new Element(makeLocator(CONCRETE_SUBCATEGORY_LOCATOR_PATTERN, category));
        subCategoryElement.waitAndClick();
        return new ConcreteCategoryPage();
    }

    private By makeLocator(String pattern, String value) {
        String locator = String.format(pattern, value);
        return  By.xpath(locator);
    }
}
