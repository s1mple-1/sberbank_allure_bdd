package sberbank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sberbank.steps.BaseSteps;

public class MainPage extends BasePage {


    @FindBy(xpath = "//button[text()='Доступно онлайн']")
    public WebElement availableOnline;

    @FindBy(xpath = "//div[text()='Ипотека на готовые квартиры']")
    public WebElement mortgageReadyElement;

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
