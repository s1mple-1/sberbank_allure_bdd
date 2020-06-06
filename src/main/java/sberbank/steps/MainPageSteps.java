package sberbank.steps;

import io.qameta.allure.Step;
import sberbank.pages.MainPage;

public class MainPageSteps {

    @Step("Выбор пункта 'Доступно онлайн'")
    public MainPageSteps selectOnlineAvailable() {
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.availableOnline);
        return this;
    }

    @Step("Выбор пункта 'Ипотека на готовые квартиры'")
    public void selectMortgageOnReadyHouses() {
        MainPage mainPage = new MainPage();
        mainPage.clickElement(mainPage.mortgageReadyElement);
    }
}
