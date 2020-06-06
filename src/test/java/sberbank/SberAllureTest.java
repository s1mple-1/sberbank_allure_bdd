package sberbank;

import org.junit.jupiter.api.Test;
import sberbank.steps.BaseSteps;
import sberbank.steps.MainPageSteps;
import sberbank.steps.MortgagePageSteps;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class SberAllureTest extends BaseTest {
    private MainPageSteps mainPageSteps = new MainPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();

    @Test
    void exTest() {
        String url = "https://www.sberbank.ru/person";
        BaseSteps.getSite(url);

        mainPageSteps.selectMortgageMenuBar().selectMortgageOnReadyHouses();
        mainPageSteps.closeCookie();
        mortgagePageSteps.connectFrameAndWaitLoading()
                .fillFields(
                        new LinkedHashMap<>() {{
                            put("Стоимость недвижимости", "5180000");
                            put("Первоначальный взнос", "3058000");
                            put("Срок кредита", "30");
                        }})
                .chooseSwitches(
                        new ArrayList<Integer>() {{
                            add(2);
                            add(3);
                            add(6);
                        }}
                )
                .checkCalcFields(
                        new LinkedHashMap<>() {{
                            put("Сумма кредита", "2122000");
                            put("Ежемесячный платеж", "16922");
                            put("Необходимый доход", "28203");
                            put("Процентная ставка", "11");
                        }});
    }


}
