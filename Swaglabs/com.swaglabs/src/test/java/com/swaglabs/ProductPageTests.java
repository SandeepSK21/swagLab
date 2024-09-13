package com.swaglabs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    @Test
    public void testProductVisibility() {
        extentTest = extentReports.createTest("Verify Product Visibility");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.isProductListDisplayed(), "Product list is not displayed.");
        Assert.assertTrue(productPage.isProductPresent("Sauce Labs Backpack"), "Sauce Labs Backpack is not present.");
        Assert.assertTrue(productPage.isProductPresent("Sauce Labs Bike Light"), "Sauce Labs Bike Light is not present.");

        extentTest.pass("Product visibility test passed.");
    }

    @Test
    public void testProductDetails() {
        extentTest = extentReports.createTest("Verify Product Details");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.viewProductDetails(0); // View details of the first product

        String expectedName = "Sauce Labs Backpack";
        String expectedPrice = "$29.99";
        String actualName = productPage.getProductDetailName();
        String actualPrice = productPage.getProductDetailPrice();

        Assert.assertEquals(actualName, expectedName, "Product name is incorrect.");
        Assert.assertEquals(actualPrice, expectedPrice, "Product price is incorrect.");

        extentTest.pass("Product details test passed.");
    }

    @Test
    public void testAddToCart() {
        extentTest = extentReports.createTest("Verify Add to Cart");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart(0); // Add the first product to the cart

        productPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart item count is not correct.");

        extentTest.pass("Add to cart test passed.");
    }
}

