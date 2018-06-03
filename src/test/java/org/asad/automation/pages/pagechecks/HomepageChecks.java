package org.asad.automation.pages.pagechecks;

import org.asad.automation.pages.Homepage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class HomepageChecks {
    @Autowired
    private Homepage homepage;

    public void checkProductCategories(String categories) {
        List<String> expectedCategories = Arrays.asList(categories.split("\\s*;\\s*"));
        List<String> actualCategories = homepage.getDepartmentalCategories();
        assertThat(expectedCategories, is(actualCategories));
    }
}
