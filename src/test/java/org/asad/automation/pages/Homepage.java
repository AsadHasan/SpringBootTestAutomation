package org.asad.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Homepage extends BasePage {
    @Value("${baseurl}")
    private String baseurl;

    @FindBy(css = "#nav-link-shopall")
    private WebElement shopByDepartment;

    public Homepage open() {
        driver.get(baseurl);
        isLoaded();
        PageFactory.initElements(driver, this);
        return this;
    }

    public void shopBy() {
        moveTo(shopByDepartment);
    }
}
