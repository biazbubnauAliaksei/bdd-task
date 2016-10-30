package com.epam.homework.step;

import com.epam.homework.framework.service.iface.NavigationService;
import com.epam.homework.framework.service.impl.NavigationServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class NavigateCategoryStep {
    private static final String INITIAL_RESOURCE_URL = "http://aliexpress.com/";
    private NavigationService service = new NavigationServiceImpl();

    @Given("start-page is open")
    public void openStartPage() {
        service.open(INITIAL_RESOURCE_URL);
    }

    @When("i choose <category>")
    public void chooseCategory(@Named("category") String category) {
        service.selectCategory(category);
    }

    @When("click <subcategory>")
    public void clickSubcategory(@Named("subcategory") String subcategory) {
        service.clickCategory(subcategory);
    }

    @Then("page is <subcategory>")
    @Given("product page is open")
    public void checkPage(String subcategory) {
        Assert.assertTrue("Open page should be subcategory page", service.isCurrentPageTarget(subcategory));
    }

}
