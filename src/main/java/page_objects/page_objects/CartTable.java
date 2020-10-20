package page_objects.page_objects;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Setter

public class CartTable extends PageObject {

    private String productRows = ".//tbody/tr";
    private String productColumns = "//tbody/tr/td";
    private String productImageFields = "//td[@class='cart_product']";
    private String descriptionFields = "//td[@class='cart_description']";
    private String productNameFields = "//p[@class='product-name']/a";
    private String statusFields = "//td[@class='cart_avail']";
    private String unitPriceFields = "//td[@class='cart_unit']";
    private String quantityValueFields = "//td[@class='cart_quantity text-center']/input[@type='hidden']";
    private String quantityButtonsMinus = "//span/i[@class='icon-minus']";
    private String quantityButtonsPlus = "//span/i[@class='icon-plus']";
    private String totalPriceFields = "//td[@class='cart_total']/span";
    private String deleteButtonFields = "//td[@class='cart_delete text-center']";

    private String productName;
    private String productStatus;
    private String productPrice;
    private String productTotal;

    private WebElement ownElement;
    private WebElement productQuantity;
    private WebElement productQuantityIncrease;
    private WebElement productQuantityDecrease;
    private WebElement deleteButtonInTable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartTable cartTable = (CartTable) o;
        return ownElement.equals(cartTable.ownElement) &&
                productName.equals(cartTable.productName) &&
                productPrice.equals(cartTable.productPrice) &&
                productQuantity.equals(cartTable.productQuantity) &&
                productTotal.equals(cartTable.productTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownElement, productName, productPrice,
                productQuantity,productTotal);
    }

    public CartTable(String productName, /*String productStatus,
                     String productPrice, WebElementFacade productQuantity,*/ String productTotal,
                     WebElement productQuantityIncrease, WebElement productQuantityDecrease,
                     WebElement deleteButtonInTable) {
        this.productName = productName;
//        this.productStatus = productStatus;
//        this.productPrice = productPrice;
        this.productTotal = productTotal;
//        this.productQuantity = productQuantity;
        this.productQuantityIncrease = productQuantityIncrease;
        this.productQuantityDecrease = productQuantityDecrease;
        this.deleteButtonInTable = deleteButtonInTable;
    }

    public CartTable(WebElement elementFacade){
        this.ownElement = elementFacade;
        this.productName = elementFacade.findElements(By.xpath(productColumns)).get(1).findElement(By.xpath(productNameFields)).getText();
//        this.duckPrice = elementFacade.thenFindAll(By.xpath(duckColumns)).get(2).getText();
//        this.duckQuantity = elementFacade.thenFindAll(By.xpath(duckColumns)).get(3).find(By.xpath(quantityField));//WebElement field
        this.productQuantityDecrease = elementFacade.findElements(By.xpath(productColumns)).get(4).findElement(By.xpath(quantityButtonsMinus));//WebElement button
        this.productQuantityIncrease = elementFacade.findElements(By.xpath(productColumns)).get(4).findElement(By.xpath(quantityButtonsPlus));//WebElementFacade button
        this.productTotal = elementFacade.findElements(By.xpath(productColumns)).get(5).findElement(By.xpath(totalPriceFields)).getText();
        this.deleteButtonInTable = elementFacade.findElements(By.xpath(productColumns)).get(5).findElement(By.xpath(deleteButtonFields));//WebElement button
    }

    public CartTable(){}

    public List<CartTable> getAllInformationFromTable(WebElement webElement){
        List<CartTable> allElemList = new ArrayList<>();
        List<WebElementFacade> rowsListGeneral = webElement.findElements(By.xpath(productRows));

        for(WebElementFacade index : rowsListGeneral){
            allElemList.add(new CartTable(index));
        }
        return allElemList;
    }
}
