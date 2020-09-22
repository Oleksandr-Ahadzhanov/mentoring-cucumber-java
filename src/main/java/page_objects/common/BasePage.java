package page_objects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigFileReader;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {


    private WebDriver driverBasePage;
    public ConfigFileReader configFileReader;

    public BasePage(WebDriver driver){
        init(driver);
    }

    public void init(final WebDriver driver) {
        this.driverBasePage = driver;
        PageFactory.initElements(driver, this);
    }

    public static void waitImplicit (WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public void waitForURL (WebDriver driver,String url){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void openURL() {
        driverBasePage.get(configFileReader.getApplicationUrl());
        waitForURL(driverBasePage,configFileReader.getApplicationUrl());
        driverBasePage.manage().window().maximize();
    }

    public void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
