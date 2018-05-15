package org.asad.automation.steps.view.viewproducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.pagechecks.HomepageChecks;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Thens implements En {
    @Autowired
    private HomepageChecks homepageChecks;

    public Thens() {
        Then("^I am presented with the available product (.*)", (String categories) -> {
            homepageChecks.checkProductCategories(categories);
        });
    }
}
