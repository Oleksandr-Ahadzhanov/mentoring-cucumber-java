package page_objects.page_objects;


import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import page_objects.common.BasePage;
import java.util.concurrent.TimeUnit;

public class SignInPageObjects extends BasePage {

    private String login = "ctc15testloy@gmail.com";
    private String password = "123321445";

    private WebDriver driverHomePage;

    public SignInPageObjects(WebDriver driver) {
        super(driver);
        this.driverHomePage=driver;
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
    @FindBy(css = "a.account")
    private WebElement accountHref;

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
        waitImplicit(driverHomePage,5, TimeUnit.SECONDS);
        pressSignInButton();
        enterDataIntoEmailField(login);
        enterDataIntoPassField(password);
        pressSubmitLoginButton();
    }

    public void ifSignedInUserPageIsOpened(){
        Boolean signedUserFieldIsPresent = driverHomePage.findElements(By.cssSelector("a.account")).size()>0;
        if(signedUserFieldIsPresent) {
            System.out.println("Signed user page is opened");
        }
    }

}
