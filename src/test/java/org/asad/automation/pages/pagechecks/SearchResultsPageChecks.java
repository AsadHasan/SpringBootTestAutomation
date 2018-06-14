package org.asad.automation.pages.pagechecks;

import org.asad.automation.pages.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Component
public class SearchResultsPageChecks {
    @Autowired
    private SearchResultsPage searchResultsPage;

    private Integer parseToInteger(String price) {
        Integer integer = null;
        try {
            integer = DecimalFormat
                    .getCurrencyInstance(Locale.getDefault())
                    .parse(price)
                    .intValue();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return integer;
    }

    public void checkResultsCategory(String category) {
        searchResultsPage.getResults()
                .stream()
                .forEach(webElement -> assertThat(webElement.getText(), containsString(category)));
    }

    public void checkResultsPrice(String price) {
        String[] priceRange = price.split(" - ");
        Integer upperPriceRange = null;
        Integer lowerPriceRange = null;

        for (String value :
                priceRange) {
            if (lowerPriceRange == null) {
                lowerPriceRange = parseToInteger(value);
            } else {
                upperPriceRange = parseToInteger(value);
            }
        }

        for (WebElement element :
                searchResultsPage.getResults()) {
            String[] elementText = element.getText().split("\n");
            for (String text :
                    elementText) {
                if (text.contains("£")) {
                    Integer actualPrice = parseToInteger(text);
                    assertThat(actualPrice, is(both(greaterThan(lowerPriceRange)).and(lessThan(upperPriceRange))));
                }
            }
        }
    }
}
