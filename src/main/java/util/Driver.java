package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    private Driver(WebDriver driver) { this.driver = driver;}

    public static WebDriver getDriver () {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
        }
        return driver;
    }
}
