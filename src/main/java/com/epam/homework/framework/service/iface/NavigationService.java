package com.epam.homework.framework.service.iface;

public interface NavigationService {

    void open(String url);

    void selectCategory(String category);

    void clickCategory(String subcategory);

    boolean isCurrentPageTarget(String title);

}
