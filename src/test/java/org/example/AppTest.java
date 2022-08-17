package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() {
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\Elena\\ПРОЕКТЫ\\Testowanie\\EPAM szkolenie\\FirstTest\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );

        WebDriver webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.get("https://github.com/login");


        WebElement logo = webDriver.findElement(By.xpath("//a[@class=\"header-logo\"]"));
        Assert.assertTrue(logo.isDisplayed());

        WebElement loginField = webDriver.findElement(By.id("login_field"));
        loginField.sendKeys("ElenaQQQ");
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys("gtLen1105");
        WebElement signInButton = webDriver.findElement(By.name("commit"));
        signInButton.click();
        WebElement profileDropDownButton = webDriver.findElement(By.xpath("//summary[@class=\"Header-link\"]/img"));
        profileDropDownButton.click();


        WebElement userInformationLabel = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"ElenaQQQ\"]")));

        Assert.assertEquals("ElenaQQQ", userInformationLabel.getText());

        webDriver.close();
        webDriver.quit();

    }

    @DataProvider(name = "wrongCredentials")
    public Object[][] wrongCredentials() {
        return new Object[][] {
                {"aaa","gtLen1105"},
                {"ElenaQQQ","gtLen11"},
                {"aaa","gtLen05"}
        };
    }

    @Test(dataProvider = "wrongCredentials")
    public void wrongCredencialsToLogin (String login, String password) {
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\Elena\\ПРОЕКТЫ\\Testowanie\\EPAM szkolenie\\FirstTest\\src\\test\\resources\\webdriver\\chromedriver.exe"
        );

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://github.com/login");


        WebElement logo = webDriver.findElement(By.xpath("//a[@class=\"header-logo\"]"));
        Assert.assertTrue(logo.isDisplayed());

        WebElement loginField = webDriver.findElement(By.id("login_field"));
        loginField.sendKeys(login);
        WebElement passwordField = webDriver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        WebElement signInButton = webDriver.findElement(By.name("commit"));
        signInButton.click();

        WebElement errorLabel = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("js-flash-container")));

        Assert.assertEquals("Incorrect username or password.", errorLabel.getText());

        webDriver.close();
        webDriver.quit();

    }
}
