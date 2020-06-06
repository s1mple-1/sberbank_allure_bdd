package sberbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sberbank.steps.BaseSteps;

public abstract class BasePage {

    public void clickToElement(WebElement webElement) {
        BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public WebElement findElement(String xpath) {
        return BaseSteps.getWebDriver().findElement(By.xpath(xpath));
    }

    public void moveToElement(WebElement webElement) {
        BaseSteps.actions.moveToElement(webElement).perform();
    }

    public WebElement waitVisibilityOf(WebElement webElement) {
        return BaseSteps.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitClickableOf(WebElement webElement) {
        return BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
