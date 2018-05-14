package org.asad.automation.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Homepage extends BasePage {

    @Autowired
    private WebDriver driver;

    @Value("${baseurl}")
    private String baseurl;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public Homepage open() {
        driver.get(baseurl);
        return this;
    }
}
