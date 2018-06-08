package org.asad.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Homepage extends BasePage {
    @Value("${baseurl}")
    private String baseurl;

    @FindBy(css = "#searchDropdownBox")
    private WebElement departmentSelector;

    @FindBy(css = "#nav-link-shopall")
    private WebElement shopByDepartmentMenu;

    @FindBy(css = ".nav-template>.nav-column>.nav-title.nav-item>.nav-text")
    private List<WebElement> categories;

    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchBar;

    @FindBy(css = "input[type=submit][value=Go].nav-input")
    private WebElement submitSearchButton;

    @Autowired
    private ProductCategoriesPage productCategoriesPage;

    @Autowired
    private SearchResults searchResults;

    public Homepage open() {
        driver.get(baseurl);
        isLoaded();
        PageFactory.initElements(driver, this);
        return this;
    }

    public Homepage shopBy(String departmentLocator) {
        moveTo(shopByDepartmentMenu)
                .moveTo(driver.findElement(By.cssSelector(departmentLocator)));
        return this;
    }

    public ProductCategoriesPage selectCategory(String categoryLocator) {
        clickWhenReady(driver.findElement(By.xpath(categoryLocator)));
        return productCategoriesPage;
    }

    public List<String> getDepartmentalCategories() {
        return categories.stream()
                .filter(element -> !element.getText().isEmpty())
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public SearchResults searchFor(String product, String... department) {
        if (department.length != 0) {
            Select departmentsDropdown = new Select(departmentSelector);
            Arrays.stream(department).forEach(s -> {
                departmentsDropdown.selectByVisibleText(s);
                whenReadyTypeIn(searchBar, product);
                clickWhenReady(submitSearchButton);
            });
            return searchResults;
        }
        whenReadyTypeIn(searchBar, product);
        clickWhenReady(submitSearchButton);
        return searchResults;
    }
}
