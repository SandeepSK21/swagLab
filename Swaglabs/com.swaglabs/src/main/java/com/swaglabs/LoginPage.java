package com.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessageForWrongCredentials() {
    	WebElement errorMessageWrongCredentials = driver.findElement(errorMessage);
        return errorMessageWrongCredentials.getText();
    }
    public String getErrorMessageForEmptyCredentials() {
    	WebElement errorMessageEmptyCredentials = driver.findElement(errorMessage);
        return errorMessageEmptyCredentials.getText();
    }
    public String getUsernameText() {
        WebElement usernameElement = driver.findElement(By.xpath("usernameLabel"));
        return usernameElement.getText();
    }
}