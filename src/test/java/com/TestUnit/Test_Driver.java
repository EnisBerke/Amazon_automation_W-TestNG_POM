package com.TestUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Test_Driver extends BaseTest{

    @DataProvider(name = "testdata")
    public Object[][] testData() {
        return new Object[][]{
                {"test@test.com", "testpassword"} /* Not necessary right now. For, if you need to test data like login info can use this "DataProvider" */
        };
    }

    @Parameters({"baseURL"})
    @Test(dataProvider = "testdata", enabled = false, description = "This code block work with DataProvider " +
            "its mean If you need to use test data like this situation u can use it " +
            "but this not work for Amazon so its disabled")
    public void Log_in (String baseURL,String mail, String password) {
        driver.get(baseURL);
        driver.findElement(By.id("nav-link-accountList")).click();
        loginPage.enterMail(mail);
        loginPage.pressContinue();
        loginPage.enterPassword(password);
        loginPage.pressSubmit();
    }

    @Parameters({"baseURL"})
    @Test(groups = "depend")
    public void ResultController(String baseURL) {
        driver.get(baseURL);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 15"+ Keys.ENTER);
        WebElement Result = driver.findElement(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div"));

        softAssert.assertTrue(Result.isDisplayed());

    }

    @Test(dependsOnMethods = "ResultController", groups = "depend")
    public void BasketCheck() {
        shopBasket.cookieAccept();
        driver.findElement(By.xpath("//div[@data-index=\"4\"]")).click();
        shopBasket.addCardAction();
        String BasketCount = driver.findElement(By.id("nav-cart-count")).getText();
        softAssert.assertNotEquals(BasketCount, "0");
    }



}
