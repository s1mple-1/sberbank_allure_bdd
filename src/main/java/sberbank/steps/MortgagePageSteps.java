package sberbank.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sberbank.pages.MortgagePage;
import sberbank.utils.AllureUtils;

import java.util.List;
import java.util.Map;

public class MortgagePageSteps {

    @Step("Подключение Frame и ожидание калькулятора")
    public MortgagePageSteps connectFrameAndWaitLoading() {
        MortgagePage mortgagePage = new MortgagePage();
        mortgagePage.switchToFrame();
        mortgagePage.waitCalcLoading();
        return this;
    }

    @Step("Заполнения полей калькулятора")
    public MortgagePageSteps fillFields(Map<String, String> fields) {
        fields.forEach(this::fillField);
        AllureUtils.takeScreenshot();
        return this;
    }

    @Step("Поле {name} заполнено значением {value}")
    private void fillField(String name, String value) {
        MortgagePage mortgagePage = new MortgagePage();
        mortgagePage.fillFields(name, value);
    }


    @Step("Выбираем необходимые опции")
    public MortgagePageSteps chooseSwitches(List<Integer> switches) {
        switches.forEach(this::chooseHelper);
        AllureUtils.takeScreenshot();
        return this;
    }

    @Step("Выбрана опция номер {number}")
    private void chooseHelper(int number) {
        MortgagePage mortgagePage = new MortgagePage();
        mortgagePage.chooseCheckBox(number);
    }

    @Step("Проверка полей калькулятора")
    public MortgagePageSteps checkCalcFields(Map<String, String> fields) {
        AllureUtils.takeScreenshot();
        fields.forEach(this::checkCalcField);
        return this;
    }

    @Step("Проверка поля {field}, ожидаемое значение {value}")
    private void checkCalcField(String field, String value) {
        MortgagePage mortgagePage = new MortgagePage();
        String actual = mortgagePage.getFillField(field);
        Assertions.assertEquals(value, actual, String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value));
    }
}
