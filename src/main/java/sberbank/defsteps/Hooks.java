package sberbank.defsteps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import sberbank.steps.BaseSteps;

public class Hooks {

    @Before
    public void start() {
        BaseSteps.init();
        BaseSteps.getSite("https://www.sberbank.ru/person");
    }

    @After
    public void quit() {
        BaseSteps.quit();
    }
}
