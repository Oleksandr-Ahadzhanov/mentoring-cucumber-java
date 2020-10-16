package page_objects.page_objects;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Setter

public class CartTable extends PageObject {

    private String productRows = ".//tbody/tr";
    private String productColumns = ".//tbody/tr/td";

    private String productImageFields = ".//td[@class='cart_product']";

    private String descriptionFields = ".//td[@class='cart_description']";
    private String productNameFields = ".//p[@class='product-name']/a";

    private String statusFields = ".//td[@class='cart_avail']";
    private String unitPriceFields = ".//td[@class='cart_unit']";
    private String totalPriceFields = ".//td[@class='cart_total']";

    private String quantityValueFields = ".//td[@class='cart_quantity text-center']/input[@type='hidden']";
    private String quantityButtonsMinus = ".//span/i[@class='icon-minus']";
    private String quantityButtonsPlus = ".//span/i[@class='icon-plus']";
    private String deleteButtonFields = ".//td[@class='cart_delete text-center']";

    private WebElementFacade ownElement;
//    private WebElementFacade table = (WebElementFacade) By.xpath(".//tbody");

    private String productName;
    private String productStatus;
    private String productPrice;
    private String productTotal;

    private WebElementFacade productQuantity;
    private WebElementFacade productQuantityIncrease;
    private WebElementFacade productQuantityDecrease;
    private WebElementFacade deleteButtonInTable;

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
                     String productPrice, WebElementFacade productQuantity,String productTotal,*/
                     WebElementFacade productQuantityIncrease, WebElementFacade productQuantityDecrease,
                     WebElementFacade deleteButtonInTable) {
        this.productName = productName;
//        this.productStatus = productStatus;
//        this.productPrice = productPrice;
//        this.productTotal = productTotal;
//        this.productQuantity = productQuantity;
        this.productQuantityIncrease = productQuantityIncrease;
        this.productQuantityDecrease = productQuantityDecrease;
        this.deleteButtonInTable = deleteButtonInTable;
    }

    public CartTable(WebElementFacade elementFacade){
        this.ownElement = elementFacade;
        this.productName = elementFacade.thenFindAll(By.xpath(productColumns)).get(1).find(By.xpath(productNameFields)).getText();
//        this.duckPrice = elementFacade.thenFindAll(By.xpath(duckColumns)).get(2).getText();
//        this.duckQuantity = elementFacade.thenFindAll(By.xpath(duckColumns)).get(3).find(By.xpath(quantityField));//WebElementFacade field
        this.productQuantityIncrease = elementFacade.thenFindAll(By.xpath(productColumns)).get(4).find(By.xpath(quantityButtonsMinus));//WebElementFacade button
        this.productQuantityDecrease = elementFacade.thenFindAll(By.xpath(productColumns)).get(4).find(By.xpath(quantityButtonsPlus));//WebElementFacade button
//        this.productTotal = elementFacade.thenFindAll(By.xpath(productColumns)).get(5).getText();
        this.deleteButtonInTable = elementFacade.thenFindAll(By.xpath(productColumns)).get(5).find(By.xpath(deleteButtonFields));//WebElementFacade button
    }

    public CartTable(){}

    public List<CartTable> getAllInformationFromTable(WebElementFacade webElementFacade){
        List<CartTable> allElemList = new ArrayList<>();
        List<WebElementFacade> rowsListGeneral = webElementFacade.thenFindAll(By.xpath(productRows));

        for(WebElementFacade index : rowsListGeneral){
            allElemList.add(new CartTable(index));
        }
        return allElemList;
    }
}
