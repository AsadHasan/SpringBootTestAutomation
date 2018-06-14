package org.asad.automation.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResultsPage extends BasePage {
    private final String FILTER_LIST_LOCATOR = "[aria-live=polite]>li>span";
    private final String RESULTS_LOCATOR = "#s-results-list-atf";

    public SearchResultsPage filterByCategory(String category) {
        WebElement filter = getElementsWhenReady(FILTER_LIST_LOCATOR)
                .stream()
                .filter(element -> getTextWhenReady(element).matches(category + "[^\\s]"))
                .findFirst()
                .get();
        clickWhenReady(filter);
        isLoaded();
        return this;
    }

    public SearchResultsPage filterByPrice(String price) {
        WebElement filter = getElementsWhenReady(FILTER_LIST_LOCATOR)
                .stream()
                .filter(element -> getTextWhenReady(element).equalsIgnoreCase(price))
                .findFirst()
                .get();
        clickWhenReady(filter);
        isLoaded();
        return this;
    }

    public List<WebElement> getResults() {
        return getElementsWhenReady(RESULTS_LOCATOR);
    }
}
