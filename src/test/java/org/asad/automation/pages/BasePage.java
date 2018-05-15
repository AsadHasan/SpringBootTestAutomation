package org.asad.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasePage {
    @Autowired
    protected WebDriver driver;

    @Value("${timeout}")
    private int timeout;

    private Actions actionBuilder(){
        return new Actions(driver);
    }

    private WebDriverWait getWait(){
        return new WebDriverWait(driver,timeout);
    }

    protected void isLoaded(){
        ExpectedCondition expectedCondition=new ExpectedCondition() {
            @Override
            public Object apply(Object o) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        getWait().until(expectedCondition);
    }

    protected void moveTo(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        actionBuilder().moveToElement(element).build().perform();
    }
}
