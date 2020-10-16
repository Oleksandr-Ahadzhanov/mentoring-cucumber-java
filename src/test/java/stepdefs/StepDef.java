package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.After;
import page_objects.page_objects.ShoppingCartPageObjects;
import page_objects.page_objects.SignInPageObjects;
import static util.driver.Driver.*;

public class StepDef {

    private SignInPageObjects homePage = new SignInPageObjects(getDriver());
    private ShoppingCartPageObjects shoppingCart = new ShoppingCartPageObjects(getDriver());

    @Given("^I am on the Home page$")
    public void app_home_page_is_opened() {
        homePage.openURL();
    }
    @When("^I do sign in$")
    public void sign_in_into_the_app() {
        homePage.signInIntoTheApp();
    }
    @Then("^I am signed in user$")
    public void check_if_user_is_signed_in() {
        homePage.ifSignedInUserPageIsOpened();
    }

    @Given("^I am on the Main page$")
    public void app_main_page_is_opened() {
        shoppingCart.openURL();
    }
    @When("^I add the Product to the Shopping Cart$")
    public void add_product_to_cart() {
        shoppingCart.addProductToCartAndOpenShoppingCart();
//        shoppingCart.encreaseQuantity();
    }
    @Then("^The product is added to the Shopping Cart$")
    public void check_if_product_is_added() {
        shoppingCart.checkIfProductIsAddedToCart();
    }

    @After
    public void driverClose(){
        closeDriver();
    }
}
