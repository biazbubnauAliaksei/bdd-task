package com.epam.homework.step;

import com.epam.homework.framework.service.iface.NavigationService;
import com.epam.homework.framework.service.impl.NavigationServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class NavigateCategoryStep {
    private static final String INITIAL_RESOURCE_URL = "http://aliexpress.com/";
    private NavigationService service = new NavigationServiceImpl();

    @Given("start-page is open")
    public void openStartPage() {
        service.open(INITIAL_RESOURCE_URL);
    }

    @When("i choose $category")
    public void chooseCategory(String category) {
        service.clickCategory(category);
    }

    @When("click $subcategory")
    public void clickSubcategory(String subCategory) {
        service.clickCategory(subCategory);
    }

    @Then("$subcategory page is open")
    public void checkPage(String subCategory) {
        assertTrue(service.isCurrentPageTarget(subCategory));
    }

}
