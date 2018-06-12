package org.asad.automation.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResults extends BasePage {
    private final String FILTER_LIST_LOCATOR = "[aria-live=polite]>li>span";

    public SearchResults filterByCategory(String category) {
        List<WebElement> categoriesList = getElementsWhenReady(FILTER_LIST_LOCATOR);
        categoriesList
                .stream()
                .filter(element -> element.getText().contains(category))
                .forEach(element -> clickWhenReady(element));
        return this;
    }

    public SearchResults filterByPrice(String price) {
        List<WebElement> categoriesList = getElementsWhenReady(FILTER_LIST_LOCATOR);
        categoriesList
                .stream()
                .filter(element -> element.getText().contains(price))
                .forEach(element -> clickWhenReady(element));
        return this;
    }
}
