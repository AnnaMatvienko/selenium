package selenium.pages.google;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SearchPage extends AbstractPage {
    private By searchLocator = By.name("qq");
    private WebElement search;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Searches for {0} text")
    public SearchPage searchFor(String searchText){
        search = webDriver.findElement(searchLocator);
        search.sendKeys(searchText);
        search.submit();
        return this;
    }
}
