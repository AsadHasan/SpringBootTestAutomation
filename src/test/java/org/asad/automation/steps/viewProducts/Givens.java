package org.asad.automation.steps.viewProducts;

import cucumber.api.java8.En;
import org.asad.automation.pages.Homepage;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Givens implements En {
    @Autowired
    private Homepage homepage;

    public Givens() {
        Given("^I am on the homepage$", () -> {
            homepage.open();
        });
    }
}
