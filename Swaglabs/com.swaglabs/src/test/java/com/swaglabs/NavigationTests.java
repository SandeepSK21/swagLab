package com.swaglabs;


import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void testNavigationBetweenPages() {
        extentTest = extentReports.createTest("Verify Navigation Between Pages");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickCartIcon();

        String expectedCartUrl = "https://www.saucedemo.com/cart.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedCartUrl, "Cart page URL is incorrect.");

        driver.navigate().back();
        String expectedProductUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedProductUrl, "Product page URL is incorrect.");

        extentTest.pass("Navigation between pages test passed.");
    }

    @Test
    public void testLogoutFunctionality() {
        extentTest = extentReports.createTest("Verify Logout Functionality");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickSideIcon();
        productPage.clickLogoutButton();
        String expectedLoginUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedLoginUrl, "User was not redirected to the login page.");

        extentTest.pass("Logout functionality test passed.");
    }
}
