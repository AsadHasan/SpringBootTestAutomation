package org.asad.automation.steps.searchProducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.Homepage;
import org.asad.automation.pages.SearchResultsPage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Whens implements En {
    @Autowired
    private Homepage homepage;
    private SearchResultsPage searchResultsPage;

    public Whens() {
        When("^I search for (.+) in (.+)$", (String product, String department) -> searchResultsPage = homepage.searchFor(product, department));
        When("^I filter results by (.+) and (.+)$", (String category, String price) -> searchResultsPage.filterByCategory(category).filterByPrice(price));
    }
}
