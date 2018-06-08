package org.asad.automation.steps.searchProducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.Homepage;
import org.asad.automation.pages.SearchResults;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Whens implements En {
    @Autowired
    private Homepage homepage;
    private SearchResults searchResults;

    public Whens() {
        When("^I search for (.+) in (.+)$", (String product, String department) -> searchResults = homepage.searchFor(product, department));
        When("^I filter results by (.+) and (.+)$", (String category, String price) ->searchResults.filterByCategory(category));
    }
}
