package page_objects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigFileReader;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected WebDriver driver;
    protected ConfigFileReader configFileReader = new ConfigFileReader();

    public BasePage(WebDriver driver){
        init(driver);
    }

    private void init(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static void waitImplicit (WebDriver driver, int amountOfTime, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(amountOfTime, timeUnit);
    }

    private void waitForURL (WebDriver driver,String url){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.urlToBe(url));
    }

    protected void waitForElementToBeVisible (WebDriver driver, WebElement element, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void openURL() {
        driver.get(configFileReader.getApplicationUrl());
        waitForURL(driver,configFileReader.getApplicationUrl());
        driver.manage().window().maximize();
    }

    protected void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void freeze(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
