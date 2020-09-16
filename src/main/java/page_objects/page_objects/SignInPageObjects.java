package page_objects.page_objects;


import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import page_objects.common.BasePage;
import java.util.concurrent.TimeUnit;

public class SignInPageObjects extends BasePage {

    private String login = "ctc15testloy@gmail.com";
    private String password = "123321445";

    public SignInPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.login")
    @CacheLookup
    private WebElement signInButtonHomePage;
    @FindBy(css="input#email")
    @CacheLookup
    private WebElement emailField;
    @FindBy(css = "input#passwd")
    private WebElement passField;
    @FindBy(css = "button#SubmitLogin")
    private WebElement submitLoginButton;

    public void pressSignInButton() { signInButtonHomePage.click(); }

    public void enterDataIntoEmailField(String data) {
        emailField.clear();
        emailField.sendKeys(data);
    }

    public void enterDataIntoPassField(String data) {
        passField.clear();
        passField.sendKeys(data);
    }

    public void pressSubmitLoginButton() {
        submitLoginButton.click();
    }

    public void signInIntoTheApp() {
        waitImplicit(driver,5, TimeUnit.SECONDS);
        pressSignInButton();
        enterDataIntoEmailField(login);
        enterDataIntoPassField(password);
        pressSubmitLoginButton();
    }

}
