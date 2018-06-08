package org.asad.automation.pages;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResults extends BasePage {
    private final String CATEGORIES_FILTER_LIST_LOCATOR = "ul.a-unordered-list.a-nostyle.a-vertical.s-ref-indent-two>div>li>span";

    public SearchResults filterByCategory(String category) {
        List<WebElement> categoriesList = getElementsWhenReady(CATEGORIES_FILTER_LIST_LOCATOR);
        categoriesList
                .stream()
                .filter(element -> element.getText().contains(category))
                .forEach(element -> clickWhenReady(element));
        return this;
    }
}
