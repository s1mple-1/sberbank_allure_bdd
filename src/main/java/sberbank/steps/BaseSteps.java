package sberbank.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberbank.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    private static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;

    public static void init() {
        Properties properties = TestProperties.getInstance().getProperties();

        String browser = properties.getProperty("browser", "opera");
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("driver"));
                webDriver = new ChromeDriver();
                break;
            case "opera":
                System.setProperty("webdriver.opera.driver", properties.getProperty("driver"));
                webDriver = new OperaDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("driver"));
                webDriver = new FirefoxDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 20);
        actions = new Actions(webDriver);
    }

    @Step("Заходим на сайт {url}")
    public static void getSite(String url) {
        webDriver.get(url);
    }

    public static void quit() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
