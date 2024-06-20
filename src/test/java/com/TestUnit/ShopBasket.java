package com.TestUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopBasket {
    private WebDriver driver;

    private By cookie = By.id("sp-cc-accept");

    private By addCardButton = By.id("add-to-cart-button");

    private By basketItemCount = By.id("nav-cart-count");

    public ShopBasket(WebDriver driver){
        this.driver = driver;
    }

    public void cookieAccept() {
        driver.findElement(cookie).click();
    }

    public void addCardAction() {
        driver.findElement(addCardButton).click();
    }

    public void basketItemCount() {
        driver.findElement(basketItemCount);
    }
}
