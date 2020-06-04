package sberbank.defsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import sberbank.steps.MainPageSteps;
import sberbank.steps.MortgagePageSteps;

public class DefSteps {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @Когда("^Закрыто всплывающее окно Cookie$")
    public void closeCookie() {
        mainPageSteps.closeCookie();
    }

    @Когда("^Выбран пункт меню 'Ипотека'$")
    public void selectMortgage() {
        mainPageSteps.selectMortgageMenuBar();
    }

    @Когда("^Выбран пунк 'Ипотека на готовое жилье'$")
    public void selectMortgageOnReadyHouses() {
        mainPageSteps.selectMortgageOnReadyHouses();
    }

    @Когда("^Подключение Frame и ожидание калькулятора$")
    public void connectFrame(){
        mortgagePageSteps.connectFrameAndWaitLoading();
    }

    @Когда("^Заполняются поля ипотечного калькулятора$")
    public void fillCalculatorForm(DataTable fields) {
        mortgagePageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @Когда("^Выбираются опции$")
    public void choose(DataTable fields){
        mortgagePageSteps.chooseSwitches(fields.asList(Integer.class));
    }

    @Тогда("^Значения полей равны$")
    public void checkApplicationFormFilled(DataTable fields) {
        mortgagePageSteps.checkCalcFields(
                fields.asMap(String.class, String.class)
        );
    }
}
