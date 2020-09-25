package page_objects.page_objects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import page_objects.common.BasePage;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingCartPageObjects extends BasePage {

//    private String expectedProductName = "Faded Short Sleeve T-shirts";

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
    @FindBy(css = "td p.product-name a")
    private WebElement productName;

//    @FindBy(css = "tr#product_1_1_0_376464")
//    private List<WebElement> mockedProduct;

    private void pressTShirtsButton() {
        tShirtsButton.click();
    }

    private void addToCartTheProduct() {
        moveToElement(productContainer);
        waitForElementToBeVisible(driver,addToCartButton,2);
        addToCartButton.click();
    }

    private void closeAddToCartPopup() {
        waitForElementToBeVisible(driver,crossButton,2);
        crossButton.click();
    }

    private void openShCart() {
        shoppingCartButton.click();
    }

    public void addProductToCartAndOpenShoppingCart(){
        waitImplicit(driver,3, TimeUnit.SECONDS);
        pressTShirtsButton();
        waitForElementToBeVisible(driver,productContainer,2);
        addToCartTheProduct();
        waitForElementToBeVisible(driver,crossButton,2);
        closeAddToCartPopup();
        waitForElementToBeVisible(driver,shoppingCartButton,2);
        openShCart();
    }

//    public void checkIfProductIsAddedToCart(){
//        boolean productIsAdded = mockedProduct.size()>0;
//        if (productIsAdded) {
//            System.out.println("Product is added to cart");
//        } else {
//            System.out.println("Product is NOT added to cart");
//        }
//    }

    public void checkIfProductIsAddedToCart() {
        String actualName = productName.getText();
        Assert.assertEquals ("Something is wrong!!!",configFileReader.getMockedProductName(),actualName);
        System.out.println("The product <" + actualName + "> is added to the Cart");
    }
}
