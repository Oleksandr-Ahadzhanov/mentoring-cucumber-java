package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

//    private WebDriver driver;

    public static WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
    }
}
