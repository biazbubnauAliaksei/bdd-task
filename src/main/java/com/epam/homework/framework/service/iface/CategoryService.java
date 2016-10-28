package com.epam.homework.framework.service.iface;

public interface CategoryService {

    void clickBrandButton(String name);

    boolean isTargetBrandSelected(String name);

    void clickFirstSearchResult();
}
