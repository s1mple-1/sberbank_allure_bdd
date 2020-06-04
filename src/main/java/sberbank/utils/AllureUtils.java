package sberbank.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sberbank.steps.BaseSteps;


public class AllureUtils {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
