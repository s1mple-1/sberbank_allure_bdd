package sberbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sberbank.steps.BaseSteps;

public abstract class BasePage {

    public void clickToElement(WebElement webElement) {
        try {
            BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (ElementClickInterceptedException e) {
            checkCookie();
            clickToElement(webElement);
        }
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

    public void scrollIntoView(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseSteps.getWebDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", webElement);
        waitVisibilityOf(webElement);
    }


    @FindBy(xpath = "//a[@class='cookie-warning__close']")
    private WebElement cookieClose;

    private void checkCookie() {
        if (!BaseSteps.getWebDriver().findElements(By.xpath("//div[@class='cookie-warning cookie-warning_show']")).isEmpty()) {
            cookieClose.click();
        }
    }
}
