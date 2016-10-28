package com.epam.homework.framework.service.impl;

import com.epam.homework.framework.service.iface.CategoryService;
import com.epam.homework.product.page.ConcreteCategoryPage;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public void clickBrandButton(String name) {
        new ConcreteCategoryPage().clickConcreteBrand(name);
    }

    @Override
    public boolean isTargetBrandSelected(String name) {
        boolean result = name.equals(new ConcreteCategoryPage().getSelectedElementTitle());
        return result;
    }

    @Override
    public void clickFirstSearchResult() {
        new ConcreteCategoryPage().clickFirstItemFromList();
    }

}
