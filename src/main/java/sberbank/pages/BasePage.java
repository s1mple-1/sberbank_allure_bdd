package sberbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sberbank.steps.BaseSteps;

abstract class BasePage {

    void clickToElement(WebElement webElement) {
        try {
            BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
            webElement.click();
        }
    }

    WebElement findElement(String xpath) {
        return BaseSteps.getWebDriver().findElement(By.xpath(xpath));
    }

    void moveToElement(WebElement webElement) {
        BaseSteps.actions.moveToElement(webElement).perform();
    }


    WebElement waitVisibilityOf(WebElement webElement) {
        return BaseSteps.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    WebElement waitClickableOf(WebElement webElement) {
        return BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    void scrollIntoView(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseSteps.getWebDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", webElement);
        waitVisibilityOf(webElement);
    }
}

