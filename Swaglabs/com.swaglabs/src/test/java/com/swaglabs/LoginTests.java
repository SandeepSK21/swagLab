package com.swaglabs;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        extentTest = extentReports.createTest("Verify Valid Login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User was not redirected to the products page.");
       
        extentTest.info("user name is not visible in Web Page so unable to Validate");
        extentTest.pass("Valid login test passed.");
    }

    @Test
    public void testInvalidLogin() {
        extentTest = extentReports.createTest("Verify Invalid Login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();

        String errorMessage1 = loginPage.getErrorMessageForWrongCredentials();
        Assert.assertTrue(errorMessage1.contains("Epic sadface"), "Error message is not as expected.");

        extentTest.pass("Invalid login test passed.");
    }

    @Test
    public void testEmptyFieldsLogin() {
        extentTest = extentReports.createTest("Verify Empty Fields");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        String errorMessage = loginPage.getErrorMessageForEmptyCredentials();
        Assert.assertTrue(errorMessage.contains("Epic sadface"), "Error message is not as expected.");

        extentTest.pass("Empty fields login test passed.");
    }
}

