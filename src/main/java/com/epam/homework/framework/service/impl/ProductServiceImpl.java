package com.epam.homework.framework.service.impl;

import com.epam.homework.framework.service.iface.ProductService;
import com.epam.homework.product.page.CartPage;
import com.epam.homework.product.page.ProductPage;

public class ProductServiceImpl implements ProductService {

    @Override
    public boolean isTargetPage() {
        return new ProductPage().isHeaderPresent();
    }

    @Override
    public void addToCart() {
        new ProductPage().addToCart();
    }

    @Override
    public boolean isAddToCardReportWindowDisplayed() {
        return new ProductPage().isAddToCardReportWindowDisplayed();
    }

    @Override
    public void goToCart() {
        new ProductPage().goToCartByReportWindowButton();
    }

    @Override
    public void removeFromCart(String header) {
        new CartPage().remove(header);
    }

    @Override
    public boolean isCartContainsProduct(String header) {
        return new CartPage().isContainsProduct(header);
    }

    @Override
    public String getProductHeader() {
        return new ProductPage().getHeader();
    }

}
