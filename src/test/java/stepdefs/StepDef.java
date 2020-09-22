package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.page_objects.SignInPageObjects;
import util.driver.Driver;

public class StepDef {


    private WebDriver driver = Driver.driver;
    private SignInPageObjects homePage = new SignInPageObjects(driver);


    @Given("^I am on the Home page$")
    public void app_home_page_is_opened() throws Exception {
        Thread.sleep(3);
        homePage.openURL();
        throw new PendingException();
    }

    @When("^I do sign in$")
    public void sign_in_into_the_app() throws Exception {
        Thread.sleep(3);
        homePage.signInIntoTheApp();
        throw new PendingException();
    }

    @Then("^I am signed in user$")
    public void check_if_user_is_signed_in() throws Exception {
        Thread.sleep(3);
        homePage.ifSignedInUserPageIsOpened();
        throw new PendingException();
    }
}
