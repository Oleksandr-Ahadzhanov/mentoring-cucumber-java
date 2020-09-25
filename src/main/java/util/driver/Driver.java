package util.driver;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        if(driver == null) {
            driver = DriverFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else {
                System.out.println("There is the problems with the driver");
        } return driver;
    }

    public static void closeDriver(WebDriver driver){
        if(driver != null) {
            driver.close();
            driver.quit();
            System.out.println("Driver is closed");
        } else {
            System.out.println("Something i wrong");
        }
    }
}
