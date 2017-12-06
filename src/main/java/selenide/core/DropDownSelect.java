package selenide.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.bouncycastle.crypto.tls.ContentType.alert;

public class DropDownSelect extends WebDriverTestBase {
    private String name;

    public void select() {
        String cancelled = "dismiss alert";
        WebElement selElem;
        selElem = webDriver.findElement(By.name(name));
        Select selectObject = new Select(selElem);
        selectObject.selectByValue(name);
        webDriver.switchTo().frame("iframeResult");
        $(By.xpath("html/body/button")).click();
        webDriver.switchTo().defaultContent();
        //       webDriver.switchTo().alert().accept(); Accept alert
        webDriver.switchTo().alert().dismiss();
        $(By.id("demo")).shouldHave(text(cancelled));
    }
}