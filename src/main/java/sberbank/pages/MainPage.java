package sberbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.steps.BaseSteps;

public class MainPage extends BasePage {


    @FindBy(xpath = "//span[text()='Ипотека']")
    public WebElement mortgage;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']//a[text()='Ипотека на готовое жильё']")
    public WebElement mortgageReadyElement;

    @FindBy(xpath = "//a[@class='cookie-warning__close']")
    private WebElement cookieClose;

    public void checkCookie() {
        if (!BaseSteps.getWebDriver().findElements(By.xpath("//div[@class='cookie-warning cookie-warning_show']")).isEmpty()) {
//            waitClickableOf(cookieClose);
//            moveAndClick(cookieClose);
            cookieClose.click();
        }
    }

    public MainPage() {
        PageFactory.initElements(BaseSteps.getWebDriver(), this);
    }

    public void moveElement(WebElement webElement) {
        waitVisibilityOf(webElement);
        moveToElement(webElement);
    }

    public void clickElement(WebElement webElement) {
        waitVisibilityOf(webElement);
        clickToElement(webElement);
    }
}
