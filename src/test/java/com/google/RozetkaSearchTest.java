package com.google;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RozetkaSearchTest {
    private String searchText = "iphone";

    @BeforeClass
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        open("https://rozetka.com.ua/");
    }

    @Test
    public void searchTest() {
//        $(By.xpath(".//*[@id='rz-search']/form/div[1]/div[2]/input")).val(searchText).pressEnter(); // or submit()
        $ (By.id("rz-search"));
        $(By.xpath("//*[@id='catalog_goods_block']/div/div[1]/div[1]/div/div[1]/div[2]/div[4]/a")).should(visible, text(searchText));
    }
}
