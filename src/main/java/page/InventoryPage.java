package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends Page {
    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> listOfItems;

    @FindBy(xpath = "//div[@class='inventory_item']//button")
    private List<WebElement> listOfItemButtons;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;


    public String getTextOfNameOfMainPageSection() {
        return nameOfMainPageSection.getText();
    }

    public int getNumberOfItems() {
        int numberOfItems = listOfItems.size();
        return numberOfItems;
    }

    public int getNumberOfButtons() {
        int numberOfButtons = listOfItemButtons.size();
        return numberOfButtons;
    }

    public List<WebElement> getListOfItems() {
        return listOfItems;
    }

    public List<WebElement> getListOfItemButtons() {
        return listOfItemButtons;
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
