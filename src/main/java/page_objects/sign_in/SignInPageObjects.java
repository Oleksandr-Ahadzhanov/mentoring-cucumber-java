package page_objects.sign_in;


import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import page_objects.InitDriver;
import util.Waiters;

import java.util.concurrent.TimeUnit;

public class SignInPageObjects extends InitDriver {

    private String login = "";
    private String password = "";

    public SignInPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="")
    @CacheLookup
    private WebElement loginField;
    @FindBy(id="")
    @CacheLookup
    private WebElement passField;
    @FindBy(css = "")
    private WebElement loginButton;
    @FindBy(className = "")
    private WebElement blackScreen;


    public void signIn(){
        Waiters.waitImplicit(driver,5, TimeUnit.SECONDS);
        enterDataIntoLoginField(login);
        enterDataIntoPassField(password);
        pressLoginButton();

    }
    private void enterDataIntoLoginField(String data) {
        loginField.clear();
        loginField.sendKeys(data);
    }
    private void enterDataIntoPassField(String data) {
        passField.clear();
        passField.sendKeys(data);
    }
    private void pressLoginButton() {
        loginButton.click();
    }

}
