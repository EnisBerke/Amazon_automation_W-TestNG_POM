package com.TestUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By mailPasswordInput = (By.id("ap_email"));

    private By continueButton = (By.id("ap_email"));

    private By submit = By.id("signInSubmit");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterMail(String mail) {
        driver.findElement(mailPasswordInput).sendKeys(mail);
    }

    public void pressContinue(){
        driver.findElement(continueButton).click();
    }

    public void enterPassword(String password){
        driver.findElement(mailPasswordInput).sendKeys(password);
    }

    public void pressSubmit(){
        driver.findElement(submit).click();
    }
}
