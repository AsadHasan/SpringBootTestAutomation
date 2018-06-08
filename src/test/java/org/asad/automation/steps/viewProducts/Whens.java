package org.asad.automation.steps.viewProducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.Homepage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Whens implements En {
    @Autowired
    private Homepage homepage;

    @Value("${department.homeGardenPetsDIY.locator}")
    private String departmentLocator;

    @Value("${productCategory.kitchenHomeApplicances.locator}")
    private String categoryLocator;

    public Whens() {
        When("^I try to shop by .+$", () -> homepage.shopBy(departmentLocator).getDepartmentalCategories());
        When("^I select a product .+$", () -> homepage.shopBy(departmentLocator).selectCategory(categoryLocator));
    }
}
