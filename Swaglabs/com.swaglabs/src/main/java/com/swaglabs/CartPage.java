package com.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;
    
    private By cartItems = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By removeButtons = By.cssSelector(".cart_button");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
    
    public void removeItem(int index) {
        WebElement button = driver.findElements(removeButtons).get(index);
        button.click();
    }

    public void completeCheckout(String name, String address, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(name);
        driver.findElement(By.id("last-name")).sendKeys(address);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
        driver.findElement(continueButton).click();
        driver.findElement(finishButton).click();
    }
}
