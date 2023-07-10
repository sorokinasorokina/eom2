
package eom_logical;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.*;

public interface Capabilities {

    default void initRemoteCapabilities(String grid, String browser) {

        switch (browser.trim().toLowerCase()) {
            case "firefox":
            case "ff":
                Configuration.browser = Browsers.FIREFOX;
//              Configuration.browserVersion = "79.0";
                break;
            case "chrome":
                Configuration.browser = Browsers.CHROME;
//              Configuration.browserVersion = "79.0";
            default:
                Configuration.browser = Browsers.FIREFOX;
//              Configuration.browserVersion = "107.0";
                break;
        }

        Configuration.timeout = 15000;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = grid.concat("/wd/hub");
//        Configuration.remote = "http://localhost:8080/wd/hub";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = desiredCapabilities;
//        open("http://school-test.mos.ru");
//        open("http://school-test.mos.ru");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().enableLogs(LogType.BROWSER, Level.ALL));


//


    }
}