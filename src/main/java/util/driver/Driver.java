package util.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null) {
            driver = DriverFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else {
                log.info("Driver is already created");
        } return driver;
    }

    public static void closeDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
            log.info("Driver is closed");
        } else {
            log.info("Something is wrong");
        }
    }
}
