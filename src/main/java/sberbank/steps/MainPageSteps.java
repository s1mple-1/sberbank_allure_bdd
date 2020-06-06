package sberbank.steps;

import io.qameta.allure.Step;
import sberbank.pages.MainPage;

public class MainPageSteps {

    @Step("Выбор пункта 'Ипотека'")
    public MainPageSteps selectMortgage() {
        MainPage mainPage = new MainPage();
        mainPage.moveElement(mainPage.mortgage);
        return this;
    }

    @Step("Выбор пункта 'Ипотека на готовое жилье'")
    public void selectMortgageOnReadyHouses() {
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.mortgageReadyElement);
    }
}
