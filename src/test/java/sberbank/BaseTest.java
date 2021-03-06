package sberbank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import sberbank.steps.BaseSteps;

class BaseTest {
    @BeforeEach
    void start() {
        BaseSteps.init();
    }

    @AfterEach
    void quit() {
        BaseSteps.quit();
    }
}
