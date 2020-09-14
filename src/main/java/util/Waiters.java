package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiters {

    private static final int WAIT_60 = 60;
    private static final int WAIT_10 = 10;

    public static void waitImplicit (WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    public static void waitForURL (WebDriver driver,String url){
        WebDriverWait wait = new WebDriverWait(driver,WAIT_60);
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT_60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
