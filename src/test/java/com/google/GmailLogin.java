package com.google;

import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailLogin {

    private String login = "auto.tests17@gmail.com";
    private String password = "pa$$w0rd17";
    private WebElement webElement, webElement2, webElement3;
    private WebDriver webDriver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-fullscreen");
//        DesiredCapabilities dCapabilities = new DesiredCapabilities();
//        dCapabilities.setCapability("unexpectedAlertBehaviour","dismiss");
        webDriver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test (enabled = false)
    public void loginTest() {
        webDriver.manage().getCookies();
        webDriver.get("https://www.gmail.com");
        webDriver.findElement(By.id("identifierId")).sendKeys(login);
        webDriver.findElement(By.id("identifierNext")).click();
//        webElement.click();
//        Thread.sleep(4000); //this command stops the whole java thread
        webDriver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys(password);
        webDriver.findElement(By.id("passwordNext")).click();
        wait.until((WebDriver wd) -> wd.findElement(By.id(":gw")));
//        webElement3 = webDriver.findElement(By.id(":gw"));
//        webElement3.isEnabled();
    }

    @AfterClass
    public void cleanup() {
        webDriver.quit();
    }
}
