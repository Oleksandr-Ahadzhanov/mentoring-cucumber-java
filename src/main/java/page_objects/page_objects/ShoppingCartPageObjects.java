package page_objects.page_objects;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import page_objects.common.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ShoppingCartPageObjects extends BasePage {

    public ShoppingCartPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/ul/li/a[@title='T-shirts']")
    @CacheLookup
    private WebElement tShirtsButton;
    @FindBy(css ="div.product-container")
    @CacheLookup
    private WebElement productContainer;
    @FindBy(css = "a[title=\"Add to cart\"] span")
    private WebElement addToCartButton;
    @FindBy(css = "span.cross")
    private WebElement crossButton;
    @FindBy(css = "a[title~=shopping]")
    private WebElement shoppingCartButton;
    @FindBy(css = "table#cart_summary tbody tr")
    private List<WebElement> listOfMockedProducts;
    @FindBy(xpath = "//table[@id='cart_summary']/tbody")
    private WebElement table;

    private void pressTShirtsButton() {
        tShirtsButton.click();
    }

    private void addToCartTheProduct() {
        moveToElement(productContainer);
        waitForElementToBeVisible(driver,addToCartButton,5);
        addToCartButton.click();
    }

    private void closeAddToCartPopup() {
        waitForElementToBeVisible(driver,crossButton,5);
        crossButton.click();
    }

    private void openShCart() {
        shoppingCartButton.click();
    }

    public void addProductToCartAndOpenShoppingCart(){
        waitImplicit(driver,5, TimeUnit.SECONDS);
        pressTShirtsButton();
        waitForElementToBeVisible(driver,productContainer,10);
        addToCartTheProduct();
        waitForElementToBeVisible(driver,crossButton,10);
        closeAddToCartPopup();
        waitForElementToBeVisible(driver,shoppingCartButton,10);
        openShCart();
    }

    public void checkIfProductIsAddedToCart(){
        boolean productIsAdded = listOfMockedProducts.size()>0;
        if (productIsAdded) {
            log.info("Product is added to cart");
            log.info("First product \"id\" is: "+listOfMockedProducts.get(0).getAttribute("id"));
            showTotalPrice();
        } else {
            System.out.println("Product is NOT added to cart");
        }
    }

    @SneakyThrows
    public void increaseQuantity() {
        CartTable cartTable = new CartTable(table);
        cartTable.getProductQuantityIncrease().click();
        showTotalPrice();
        Thread.sleep(2000);
    }

    private void showTotalPrice() {
        CartTable cartTable = new CartTable(table);
        log.info("Product total price is: " + cartTable.getProductTotal());
        System.out.println();
    }

}
