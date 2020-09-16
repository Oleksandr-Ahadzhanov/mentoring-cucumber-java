package page_objects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigFileReader;
import java.util.concurrent.TimeUnit;

public class BasePage {


    public WebDriver driver;
    public ConfigFileReader configFileReader;

    public BasePage(WebDriver driver){
        init(driver);
    }

    public void init(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void waitImplicit (WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public void waitForURL (WebDriver driver,String url){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void openURL(String url) {
        driver.get(configFileReader.getApplicationUrl());
        waitForURL(driver,url);
        driver.manage().window().maximize();
    }



}
