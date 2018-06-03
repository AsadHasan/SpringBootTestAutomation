package org.asad.automation.steps.view.viewproducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.pagechecks.HomepageChecks;
import org.asad.automation.pages.pagechecks.ProductCategoriesPageChecks;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Thens implements En {
    @Autowired
    private HomepageChecks homepageChecks;

    @Autowired
    private ProductCategoriesPageChecks productCategoriesPageChecks;

    @Value("${subdepartments.kitchenHomeAplliances}")
    private String departmentsLocator;

    public Thens() {
        Then("^I am presented with the available product (.+)$", (String categories) -> homepageChecks.checkProductCategories(categories));
        Then("^I am presented with (.+) titles$", (String subDepartments) -> productCategoriesPageChecks.checkSubDepartments(subDepartments, departmentsLocator));
        Then("^list of (.+) within that (.+)$", (String categories, String subdepartment) -> productCategoriesPageChecks
                .checkSubDepartmentalCategories(categories, subdepartment, departmentsLocator));
    }
}
