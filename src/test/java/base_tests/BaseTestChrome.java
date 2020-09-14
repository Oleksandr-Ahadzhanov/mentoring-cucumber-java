package base_tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static util.Waiters.waitForURL;
import static util.Waiters.waitImplicit;

public class BaseTestChrome {

    WebDriver driver;
    private static final String exePath = ".src/main/resources/drivers/chromedriver.exe";

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        waitImplicit(driver,5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    void openURL(String url) {
        driver.get(url);
        waitForURL(driver,url);
        driver.manage().window().maximize();
    }

}
