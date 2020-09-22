package util.driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    @Before
    public void initializeDriver(){
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        if(driver == null) {
            System.out.println("There is the problems with the driver");
        }
    }

    @After
    public void closeDriver(){
        driver.quit();
        System.out.println("Driver is closed");
    }
}
