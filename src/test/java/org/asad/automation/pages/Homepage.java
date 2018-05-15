package org.asad.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Homepage extends BasePage {
    @Value("${baseurl}")
    private String baseurl;

    @FindBy(css = "#nav-link-shopall")
    private WebElement shopByDepartmentMenu;

    @FindBy(css = "[data-nav-panelkey=HomeGardenPetsAndDIYPanel]")
    private WebElement homeGardenPetsDiyOption;

    @FindBy(css = ".nav-template>.nav-column>.nav-title.nav-item>.nav-text")
    private List<WebElement> homeGardenPetsDiyOptions;

    public Homepage open() {
        driver.get(baseurl);
        isLoaded();
        PageFactory.initElements(driver, this);
        return this;
    }

    public Homepage shopBy() {
        moveTo(shopByDepartmentMenu)
                .moveTo(homeGardenPetsDiyOption);
        return this;
    }

    public List<String> getCategories() {
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element : homeGardenPetsDiyOptions) {
            String text = element.getText();
            if (!text.isEmpty()) {
                elementTexts.add(text);
            }
        }
        return elementTexts;
    }
}
