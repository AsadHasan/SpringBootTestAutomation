package org.asad.automation.steps.searchProducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.pagechecks.SearchResultsPageChecks;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Thens implements En {
    @Autowired
    private SearchResultsPageChecks searchResultsPageChecks;

    public Thens() {
        Then("^only results with (.+) and (.+) are shown$", (String category, String price) -> {
            searchResultsPageChecks.checkResultsCategory(category);
            searchResultsPageChecks.checkResultsPrice(price);
        });
    }
}
