package com.epam.homework.step;

import com.epam.homework.framework.service.iface.ProductService;
import com.epam.homework.framework.service.impl.ProductServiceImpl;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class RemoveFromCartSteps {

    private ProductService service = new ProductServiceImpl();
    private String productHeader;

    @When("I remove product")
    public void removeProductFromCart() {
        productHeader = service.getProductHeader();
        service.removeFromCart(productHeader);
    }

    @Then("cart not contain product")
    public void checkCartForProduct() {
        Assert.assertFalse("Cart should not contains product", service.isCartContainsProduct(productHeader));
    }

}
