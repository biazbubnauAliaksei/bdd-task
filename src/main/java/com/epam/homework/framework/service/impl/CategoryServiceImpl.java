package com.epam.homework.framework.service.impl;

import com.epam.homework.framework.service.iface.CategoryService;
import com.epam.homework.product.page.CategoryPage;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public void clickBrandButton(String name) {
        new CategoryPage().clickConcreteBrand(name);
    }

    @Override
    public boolean isTargetBrandSelected(String name) {
        boolean result = name.equals(new CategoryPage().getSelectedElementTitle());
        return result;
    }

    @Override
    public void clickFirstSearchResult() {
        new CategoryPage().clickFirstItemFromList();
    }

}
