package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.InventoryPageService;
import service.LoginPageService;

public class DropDown {

    private LoginPageService loginPageService;
    private User user;
    private DropDown dropDown;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test
    public void checkNameDropDown() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        String expectedText1 = "Name (A to Z)";

    }
}

