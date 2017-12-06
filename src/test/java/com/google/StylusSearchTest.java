package com.google;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class StylusSearchTest {
    private WebDriver webDriver;
    private String searchText = "Sony Xperia Z2";

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://stylus.ua/");
    }

    @Test
    public void searchTest() {
        By searchFieldLocator = By.xpath("//*[@id='head-search']/form/input[1]");
        WebElement searchField = webDriver.findElement(searchFieldLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By resultLinkLocator = By.xpath("//*[@id='search-list']/ul/li[3]/a/span");
        WebElement resultLink = webDriver.findElement(resultLinkLocator);
        assertTrue(resultLink.getText().contains(searchText));
        resultLink.click();
        webDriver.getPageSource().contains(searchText);
    }

    @AfterClass
    public void tearDown() {
        webDriver.quit();
    }
}
