package com.TestUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;

    LoginPage loginPage;

    ShopBasket shopBasket;

    SoftAssert softAssert;

    @Parameters({"browser"})
    @BeforeClass(groups = "depend")
    public void setUp(String browser) {
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unknown browser");
        }
        shopBasket = new ShopBasket(driver);
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
        System.setProperty("webdriver.gecko.driver","C:\\webdrivers\\geckodriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterClass(enabled = true)
    public void tearDown() {
        driver.quit();
        softAssert.assertAll();
    }
}
