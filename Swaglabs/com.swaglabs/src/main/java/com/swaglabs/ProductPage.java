package com.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

	public class ProductPage {
	    private WebDriver driver;
	    
	    private By productList = By.className("inventory_item");
	    private By productName = By.className("inventory_item_name");
	    private By productPrice = By.className("inventory_item_price");
	    private By addToCartButtons = By.cssSelector(".btn_inventory");
	    private By cartIcon = By.className("shopping_cart_link");
	    private By sideicon = By.xpath("//div[@class='bm-burger-button']//button");
	    private By logoutOption = By.xpath("//a[@id='logout_sidebar_link']");
	    


	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isProductListDisplayed() {
	        return driver.findElements(productList).size() > 0;
	    }
        
	    public boolean isProductPresent(String productName) {
	        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
	        for (WebElement product : products) {
	            if (product.getText().equals(productName)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public void addProductToCart(int index) {
	        WebElement button = driver.findElements(addToCartButtons).get(index);
	        button.click();
	    }

	    public void viewProductDetails(int index) {
	        WebElement product = driver.findElements(productList).get(index);
	        product.click();
	    }

	    public String getProductDetailName() {
	        return driver.findElement(productName).getText();
	    }

	    public String getProductDetailPrice() {
	        return driver.findElement(productPrice).getText();
	    }

		public void clickCartIcon() {
			WebElement carticon = driver.findElement(cartIcon);
	        carticon.click();
		}
		public void clickSideIcon() {
			WebElement sideIcon = driver.findElement(sideicon);
	        sideIcon.click();
		}
		public void clickLogoutButton() {
			WebElement logoutButton = driver.findElement(logoutOption);
	        logoutButton.click();
		}

	}
