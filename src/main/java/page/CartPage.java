package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page {

    @FindBy(className = "cart_item")
    private List<WebElement> listOfItemsInCart;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> listOfItemNamesInCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartCounter;

    @FindBy(xpath = "//div[@class='cart_item']//button")
    private List<WebElement> listOfRemoveButtonsInCart;


    public List<WebElement> getListOfItemsInCart() {
        return listOfItemsInCart;
    }

    public List<WebElement> getListOfItemNamesInCart() {
        return listOfItemNamesInCart;
    }

    public int getNumberOfItemsInCart() {
        int numberOfItems = listOfItemsInCart.size();
        return numberOfItems;
    }

    public int getNumberOfProductNamesInCart() {
        int numberOfItemNames = listOfItemNamesInCart.size();
        return numberOfItemNames;
    }

    public WebElement getCartCounter() {
        return cartCounter;
    }

    public List<WebElement> getListOfRemoveButtonsInCart() {
        return listOfRemoveButtonsInCart;
    }
}
