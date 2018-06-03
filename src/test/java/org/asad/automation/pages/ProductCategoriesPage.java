package org.asad.automation.pages;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCategoriesPage extends BasePage {
    public List<String> getSubdepartments(String elementListLocator) {
        return getElementsWhenReady(elementListLocator)
                .stream()
                .filter(element -> !element.getText().isEmpty())
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
