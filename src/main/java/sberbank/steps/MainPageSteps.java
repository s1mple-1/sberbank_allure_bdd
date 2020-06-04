package sberbank.steps;

import io.qameta.allure.Step;
import sberbank.pages.MainPage;

public class MainPageSteps {

    @Step("Закрыть всплывающиее окно 'Cookie'")
    public MainPageSteps closeCookie() {
        MainPage mainPage = new MainPage();
        mainPage.checkCookie();
        return this;
    }

    @Step("Выбор пункта 'Ипотека'")
    public MainPageSteps selectMortgageMenuBar() {
        MainPage mainPage = new MainPage();
        mainPage.moveToElement(mainPage.mortgageMenuBarElement);
        return this;
    }

    @Step("Выбор пункта 'Ипотека на готовое жилье'")
    public void selectMortgageOnReadyHouses() {
        MainPage mainPage = new MainPage();
        mainPage.moveElement(mainPage.mortgageReadyElement);
        mainPage.clickElement(mainPage.mortgageReadyElement);
    }
}
