package sberbank.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberbank.steps.BaseSteps;

public class MortgagePage extends BasePage {
    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    private WebElement frame;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;//сумма кредита

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;//ежемесячный платеж

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;//необходимый доход

    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;//процентная ставка

    @FindBy(xpath = "//input[@id='estateCost']")
    private WebElement estateCost;//стоимость жилья

    @FindBy(xpath = "//input[@id='initialFee']")
    private WebElement initialFee;//первоначальный взнос

    @FindBy(xpath = "//input[@id='creditTerm']")
    private WebElement creditTerm;//срок кредита


    @FindBy(xpath = "//div[text()='Есть возможность подтвердить доход справкой']")
    private WebElement checkIncomeElement;


    public MortgagePage() {
        PageFactory.initElements(BaseSteps.getWebDriver(), this);
    }

    public void switchToFrame() {
        BaseSteps.getWebDriver().switchTo().frame(frame);
    }

    public void fillFields(String fieldName, String value) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fillField(estateCost, value);
                break;
            case "Первоначальный взнос":
                fillField(initialFee, value);
                break;
            case "Срок кредита":
                fillField(creditTerm, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void fillField(WebElement fieldElement, String value) {
        fieldElement.clear();
        waitRefreshingValues();
        fieldElement.sendKeys(value);
        waitRefreshingValues();
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Сумма кредита":
                return getText(amountOfCredit);
            case "Ежемесячный платеж":
                return getText(monthlyPayment);
            case "Необходимый доход":
                return getText(requiredIncome);
            case "Процентная ставка":
                return getText(rate);
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void chooseCheckBox(int numberSwitch) {
        String switchControls = "(//span[@class='dcCalc_switch__control'])[%s]";
        WebElement switchElement = findElement(String.format(switchControls, String.valueOf(numberSwitch)));
        scrollIntoView(switchElement);
        moveToElement(switchElement);
        waitClickableOf(switchElement);
        clickToElement(switchElement);
        waitRefreshingValues();
        if (numberSwitch == 2) {
            waitVisibilityOf(checkIncomeElement);
        }
    }

    // функция ожидания для корректной работы с полями ипотечного калькулятора
    private void waitRefreshingValues() {
        waitVisibilityOf(requiredIncome);//ждем целового поля
        WebDriverWait webDriverWait = new WebDriverWait(BaseSteps.getWebDriver(), 10);
        webDriverWait.until(webDriver -> {
            String oldValue = requiredIncome.getText();//берем старое значение целевого поля
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String newValue = requiredIncome.getText();//получаем новое значение целевого поля
            return newValue.equals(oldValue);//если значение не равны ждем
        });
    }

    public void waitCalcLoading() {
        waitVisibilityOf(requiredIncome);
    }

    private String getText(WebElement webElement) {
        return webElement.getText().replaceAll("[^0-9,]", "");
    }

    private void scrollIntoView(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseSteps.getWebDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", webElement);
        waitVisibilityOf(webElement);
    }
}