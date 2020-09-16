package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import util.Driver;
import java.util.concurrent.TimeUnit;

public class StepDef {

    private WebDriver driver;

    @Before
    public void initializeDriver(){
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeDriver(){
        driver.quit();
    }

    @Given("^I am on the Home page$")
    public void app_home_page_is_opened() throws Exception {
        // Write code here that turns the phrase above into concrete actions

        throw new PendingException();
    }

    @When("^I do sign in$")
    public void sign_in_into_the_app() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am signed in user$")
    public void check_if_user_is_signed_in() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
