package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "login_field")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("https://github.com/login");
        return this;
    }

    public HomePage login(String userName, String password) {
        this.userName.sendKeys(userName);
        this.passwordField.sendKeys(password);
        signInButton.click();

        return new HomePage(webDriver);
    }
}
