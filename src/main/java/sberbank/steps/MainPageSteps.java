package sberbank.steps;

import io.qameta.allure.Step;
import sberbank.pages.MainPage;

public class MainPageSteps {

    @Step("Закрытие Cookie")
    public MainPageSteps closeCookie() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainPage mainPage = new MainPage();
        mainPage.checkCookie();
        return this;
    }

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
