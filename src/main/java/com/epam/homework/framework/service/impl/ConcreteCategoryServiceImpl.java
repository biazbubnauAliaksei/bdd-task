package com.epam.homework.framework.service.impl;

import com.epam.homework.framework.service.iface.ConcreteCategoryService;
import com.epam.homework.product.page.ConcreteCategoryPage;

public class ConcreteCategoryServiceImpl implements ConcreteCategoryService {

    @Override
    public void clickBrandButton(String name) {
        new ConcreteCategoryPage().clickConcreteBrand(name);
    }

    @Override
    public boolean isTargetBrandSelected(String name) {
        return name.equals(new ConcreteCategoryPage().getSelectedElementTitle());
    }
}
