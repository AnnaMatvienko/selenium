package selenium.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends AbstractPage {

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    private java.util.List<WebElement> links = webDriver.findElements(By.tagName("#ires .g"));

    public java.util.List<WebElement> getLinks() {
        return links;
    }
}
