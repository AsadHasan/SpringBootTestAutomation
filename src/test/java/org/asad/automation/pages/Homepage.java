package org.asad.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Homepage extends BasePage {
    @Value("${baseurl}")
    private String baseurl;

    @FindBy(css = "#nav-link-shopall")
    private WebElement shopByDepartmentMenu;

    @FindBy(css = ".nav-template>.nav-column>.nav-title.nav-item>.nav-text")
    private List<WebElement> categories;

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

    public Homepage selectCategory(String categoryLocator) {
        clickWhenReady(driver.findElement(By.xpath(categoryLocator)));
        return this;
    }

    public List<String> getDepartmentalCategories() {
        return categories.stream()
                .filter(element -> !element.getText().isEmpty())
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
