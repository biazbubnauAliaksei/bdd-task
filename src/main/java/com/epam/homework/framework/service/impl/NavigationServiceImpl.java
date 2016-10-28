package com.epam.homework.framework.service.impl;

import com.epam.homework.framework.browser.Browser;
import com.epam.homework.framework.service.iface.NavigationService;
import com.epam.homework.product.page.CategoryPage;
import com.epam.homework.product.page.MainPage;

public class NavigationServiceImpl implements NavigationService {

    @Override
    public void open(String url) {
        Browser.getBrowser().open(url);
        new MainPage().handleStartingWindow();
    }

    @Override
    public void selectCategory(String category) {
        new MainPage().selectCategory(category);
    }

    @Override
    public void clickCategory(String subcategory) {
        new MainPage().clickCategory(subcategory);
    }

    @Override
    public boolean isCurrentPageTarget(String title) {
        String categoryTitle = new CategoryPage().getTitle();
        return categoryTitle.contains(title);
    }
}
