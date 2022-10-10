package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {
    public WebElement loginLink()
    {
        return Hooks.driver.findElement(By.className("ico-login"));
    }
    public WebElement email()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement password()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.className("login-button"));
    }
    public WebElement errorMessage()
    {
        return  Hooks.driver.findElement(By.className("message-error"));
    }
    public void login(String email, String password) {
        email().sendKeys(email);
        password().sendKeys(password);
        loginButton().click();
    }
    public WebElement accountTab()
    {
        return Hooks.driver.findElement(By.className("ico-account"));
    }
}
