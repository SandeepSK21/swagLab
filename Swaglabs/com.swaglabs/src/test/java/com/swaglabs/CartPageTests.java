package com.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {

    @Test
    public void testViewCart() {
        extentTest = extentReports.createTest("Verify View Cart");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart(0);
        productPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.getCartItemCount() > 0, "Cart does not contain any items.");

        extentTest.pass("View cart test passed.");
    }

    @Test
    public void testRemoveItemFromCart() {
        extentTest = extentReports.createTest("Verify Remove Item from Cart");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart(0); 
        
        productPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart item count should be 1 before removal.");

        cartPage.removeItem(0);
        Assert.assertEquals(cartPage.getCartItemCount(), 0, "Cart item count should be 0 after removal.");

        extentTest.pass("Remove item from cart test passed.");
    }

    @Test
    public void testCheckoutProcess() {
        extentTest = extentReports.createTest("Verify Checkout Process");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart(0);

        productPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);

        cartPage.proceedToCheckout();
        cartPage.completeCheckout("Sandeep", "Soundarrasu", "600056");

        extentTest.pass("Checkout process test passed.");
    }
}

