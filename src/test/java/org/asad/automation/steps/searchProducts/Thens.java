package org.asad.automation.steps.searchProducts;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Thens implements En {
    public Thens() {
        Then("^only results with (.+) and (.+) are shown$", (String category, String price) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
