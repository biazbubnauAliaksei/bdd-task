package com.epam.homework.step;

import com.epam.homework.framework.service.impl.CategoryServiceImpl;
import com.epam.homework.framework.service.impl.ProductServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class SelectProductStep {

    @When("I click on search result")
    public void clickOnSearchResult() {
        new CategoryServiceImpl().clickFirstSearchResult();
    }

    @Then("I get product page")
    @Given("product page")
    public void getProductPage() {
        assertTrue("Open page should be target product page", new ProductServiceImpl().isTargetPage());
    }
}
