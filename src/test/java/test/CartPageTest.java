package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.CartPageService;
import service.InventoryPageService;
import service.LoginPageService;

import java.util.Arrays;
public class CartPageTest extends BaseTest {
    private int itemIndex;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test
    public void checkNameOfAddedItemInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        itemIndex = 4;
        String nameOfAddedToCartProduct = inventoryPageService.getProductNameByIndex(itemIndex);
        inventoryPageService.clickAddToCartButtonByIndex(itemIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        String[] namesOfProductsInCart = cartPageService.getProductNamesInCart();
        Boolean isProductInCart = Arrays.asList(namesOfProductsInCart).contains(nameOfAddedToCartProduct);
        Assert.assertTrue(isProductInCart);
    }

    @Test
    public void checkCounterValueMatchNumberOfProductsInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        itemIndex = 1;
        inventoryPageService.clickAddToCartButtonByIndex(itemIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        int numberOfProductsInCart = cartPageService.getProductNamesInCart().length;
        int counterValue = cartPageService.getCartCounterValue();
        Assert.assertEquals(numberOfProductsInCart, counterValue);
    }

    @Test
    public void checkProductCanBeRemovedFromCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        itemIndex = 3;
        inventoryPageService.clickAddToCartButtonByIndex(itemIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        int initialNumberOfProductsInCart = cartPageService.getProductNamesInCart().length;
        cartPageService.RemoveFirstProductInCart();
        int numberOfProductsInCartAfterRemoving = cartPageService.getProductNamesInCart().length;
        int removedAmount = initialNumberOfProductsInCart - numberOfProductsInCartAfterRemoving;
        Assert.assertEquals(removedAmount, 1);
    }
}
