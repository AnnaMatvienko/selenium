package selenide.pages.google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement search = $(By.name("q"));

    //@Step("Searches for {0} text")

    public SearchPage searchFor(String searchText) {
        search.val(searchText).pressEnter();
        return this;
    }
}
