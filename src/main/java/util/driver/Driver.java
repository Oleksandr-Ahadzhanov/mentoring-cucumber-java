package util.driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

//    public Driver(){driver=initializeDriver();}

    @Before
    public static WebDriver initializeDriver(){
        if(driver == null) {
            driver = DriverFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else {
                System.out.println("There is the problems with the driver");
        } return driver;
    }

    @After
    public void closeDriver(){
//        driver.close();
        driver.quit();
        System.out.println("Driver is closed");
    }
}
