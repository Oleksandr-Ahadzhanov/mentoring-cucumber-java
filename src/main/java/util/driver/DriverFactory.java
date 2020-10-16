package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

class DriverFactory {

//    private WebDriver driver;

    static WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
    }

//    @SneakyThrows
//    static WebDriver getDriver() {
//        DesiredCapabilities browser = new DesiredCapabilities();
//        browser.setBrowserName("chrome");
//        browser.setCapability("enableVNC", true);
//
//        RemoteWebDriver driver = new RemoteWebDriver(
//                URI.create("http://18.196.189.98:4444/wd/hub").toURL(),
//                browser);
//            return driver;
//    }
}
