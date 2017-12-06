package com.google;

import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import selenide.core.WebDriverTestBase;
import selenium.pages.google.SearchPage;

@Feature("Google search")
@Story("Story1")
public class SeleniumGoogleSearchTest extends WebDriverTestBase {
    private String selenium = "Selenium";

    @Test
    public void search() {
        SearchPage searchPage = new SearchPage(webDriver);
        webDriver.get("https://www.google.com.ua/");
        searchPage.searchFor(selenium);
        SearchPage searchResultPage = new SearchPage(webDriver);

    }
}
