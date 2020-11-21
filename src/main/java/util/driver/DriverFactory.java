package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

class DriverFactory {

    private static WebDriver driver;
    private static String driverName;

    static WebDriver getDriver() {

         driverName = System.getProperty("driver")== null ? "chrome" : System.getProperty("driver");

         switch (driverName){
             case ("chrome"):
                 WebDriverManager.chromedriver().setup();
                 driver = new  ChromeDriver();
                 break;
             case ("firefox"):
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
             case ("edge"):
                 WebDriverManager.firefoxdriver().setup();
                 driver = new EdgeDriver();
                 break;
             default:
                 WebDriverManager.chromedriver().setup();
                 driver = new  ChromeDriver();
                 break;
         }
         return driver;
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
