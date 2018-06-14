package org.asad.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BasePage {
    @Autowired
    protected WebDriver driver;

    @Value("${timeout}")
    private int timeout;

    private Actions actionBuilder() {
        return new Actions(driver);
    }

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, timeout);
    }

    protected void isLoaded() {
        ExpectedCondition expectedCondition = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        getWait().until(expectedCondition);
    }

    protected BasePage moveTo(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        actionBuilder().moveToElement(element).build().perform();
        return this;
    }

    protected BasePage clickWhenReady(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return this;
    }

    protected List<WebElement> getElementsWhenReady(String locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
        return driver.findElements(By.cssSelector(locator));
    }

    protected BasePage whenReadyTypeIn(WebElement element, String text) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
        return this;
    }

    protected String getTextWhenReady(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }
}
