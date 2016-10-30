package com.epam.homework.step;

import com.epam.homework.framework.service.iface.CategoryService;
import com.epam.homework.framework.service.impl.CategoryServiceImpl;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertTrue;

public class SearchByBrandNameStep {

    private CategoryService service = new CategoryServiceImpl();


    @When("I choose <name>")
    public void selectBrandName(@Named("name") String name) {
        service.clickBrandButton(name);
    }

    @Then("get <name> result page")
    @Given("result page is open")
    public void getSearchResultPage(@Named("name") String name) {
        assertTrue("Open page should be concrete brand page", service.isTargetBrandSelected(name));
    }

}
