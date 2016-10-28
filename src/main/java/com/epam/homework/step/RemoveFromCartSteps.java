package com.epam.homework.step;

import com.epam.homework.framework.service.iface.ProductService;
import com.epam.homework.framework.service.impl.ProductServiceImpl;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class RemoveFromCartSteps {

    private ProductService service = new ProductServiceImpl();

    @When("I go to cart")
    public void goToCart() {
        new ProductServiceImpl().goToCart();
    }

    @When("remove product")
    public void removeProductFromCart() {
        service.removeFromCart();
    }

    @Then("cart not contain product")
    public void checkCartForProduct() {
        assertTrue(service.isCartContainsProduct());
    }

}
