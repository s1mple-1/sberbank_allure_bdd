package sberbank.steps;

import io.qameta.allure.Step;
import sberbank.pages.MainPage;
import sberbank.utils.AllureUtils;

public class MainPageSteps {

    @Step("Закрыть всплывающиее окно 'Cookie'")
    public MainPageSteps closeCookie() {
        MainPage mainPage = new MainPage();
        mainPage.checkCookie();
        return this;
    }

    @Step("Выбор пункта 'Доступно онлайн'")
    public MainPageSteps selectMortgageMenuBar() {
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
