package pages;

import io.appium.java_client.AppiumBy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class BankScreen extends BaseAction{
    private WebElement backButton = driver.findElement(AppiumBy.accessibilityId("Повернутись"));

    @SneakyThrows
    public void tapBackButton() {
        driver.navigate().back();

//        isElementDisplayedLazy(backButton);
//        waitUntilClickable(backButton).click();
    }
}
