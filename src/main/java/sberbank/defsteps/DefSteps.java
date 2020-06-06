package sberbank.defsteps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sberbank.steps.MainPageSteps;
import sberbank.steps.MortgagePageSteps;

public class DefSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();


    @When("Выбран пункт 'Доступно онлайн'")
    public void selectMortgage() {
        mainPageSteps.selectOnlineAvailable();
    }

    @When("Выбран пункт 'Ипотека на готовые квартиры'")
    public void selectMortgageOnReadyHouses() {
        mainPageSteps.selectMortgageOnReadyHouses();
    }

    @When("Подключение Frame и ожидание калькулятора")
    public void connectFrame() {
        mortgagePageSteps.connectFrameAndWaitLoading();
    }

    @When("Заполняются поля ипотечного калькулятора")
    public void fillCalculatorForm(DataTable fields) {
        mortgagePageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @Then("Выбираются опции")
    public void choose(DataTable fields) {
        mortgagePageSteps.chooseSwitches(fields.asList(Integer.class));
    }

    @Then("Значения полей равны")
    public void checkApplicationFormFilled(DataTable fields) {
        mortgagePageSteps.checkCalcFields(
                fields.asMap(String.class, String.class)
        );
    }
}
