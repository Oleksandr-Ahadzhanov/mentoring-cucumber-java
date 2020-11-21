package page_objects.page_objects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import page_objects.common.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SignInPageObjects extends BasePage {

    public SignInPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.login")
    @CacheLookup
    private WebElement signInButtonHomePage;
    @FindBy(css ="input#email")
    @CacheLookup
    private WebElement emailField;
    @FindBy(css = "input#passwd")
    private WebElement passField;
    @FindBy(css = "button#SubmitLogin")
    private WebElement submitLoginButton;
    @FindBy(css = "a.account")
    private List<WebElement> accountHref;

    private void pressSignInButton() {
        waitForElementToBeVisible(driver,signInButtonHomePage,2);
        signInButtonHomePage.click();
    }

    private void enterDataIntoEmailField(String data) {
        emailField.clear();
        emailField.sendKeys(data);
    }

    private void enterDataIntoPassField(String data) {
        passField.clear();
        passField.sendKeys(data);
    }

    private void pressSubmitLoginButton() {
        submitLoginButton.click();
    }

    public void signInIntoTheApp() {
        waitImplicit(driver,10, TimeUnit.SECONDS);
        pressSignInButton();
        enterDataIntoEmailField(configFileReader.getUserLogin());
        enterDataIntoPassField(configFileReader.getUserPassword());
        pressSubmitLoginButton();
    }

    public void ifSignedInUserPageIsOpened(){
        boolean signedUserFieldIsPresent = accountHref.size()>0;
        if(signedUserFieldIsPresent) {
            log.info("Signed user page is opened");
        } else {log.info("Signed user page is NOT opened");}
    }
}
