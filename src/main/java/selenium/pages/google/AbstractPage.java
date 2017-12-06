package selenium.pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(this.webDriver, 10);
    }
    public AbstractPage waitFor(ExpectedCondition<WebElement> expectedConditions){
        webDriverWait.until(expectedConditions);
        return this;
    }
}
