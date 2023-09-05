package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.InventoryPageService;
import service.LoginPageService;

public class AddToCart {

    private LoginPageService loginPageService;
    private User user;
    private AddToCart addToCart;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test
    public void checkAddToCartButton() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        String expectedButtonText1 = "Add to cart";
        String expectedButtonText2 = "Remove";
    }
}
