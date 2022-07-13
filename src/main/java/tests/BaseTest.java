package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        Configuration.browser = System.getProperty("browser");
        Configuration.startMaximized = true;
        Configuration.timeout = 10 * 1000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    public static synchronized WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
