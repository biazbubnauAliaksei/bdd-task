package com.epam.homework.framework.service.iface;

public interface ProductService {
    boolean isTargetPage();

    String getProductHeader();

    void addToCart();

    boolean isAddToCardReportWindowDisplayed();

    void goToCart();

    void removeFromCart(String header);

    boolean  isCartContainsProduct(String header);
}
