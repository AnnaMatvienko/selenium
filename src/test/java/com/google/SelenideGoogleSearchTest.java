package com.google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.google.SearchPage;
import selenide.pages.google.SearchResultPage;
import selenide.util.PropertiesCache;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideGoogleSearchTest extends SelenideTestBase {
    //private String searchText = "selenide";
    private String searchText = PropertiesCache.getProperty("text");
    private SearchPage searchPage = new SearchPage();

    //TODO WEB-4409

    @Test
    public void searchTest() {
        open("https://www.google.com.ua/");
        $(By.name("q")).val(searchText).pressEnter(); // or submit()
        $(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/h3/a")).should(visible, text(searchText));
        $$("#ires .g").shouldHave(size(9)); //displays 9 links according to the search query
    }

    @Test(enabled = true)
    public void pageObjectSearchTest() {
        open("https://www.google.com/ncr");
        searchPage.searchFor(searchText);
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.getLinkResults()
                .shouldHaveSize(9)
                .first()
                .should(text("Selenide: concise UI tests in Java"));
    }
}