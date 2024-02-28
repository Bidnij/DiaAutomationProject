package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;

public class BankScreen extends BaseAction{
//    private WebElement backButton = driver.findElement(AppiumBy.accessibilityId("Повернутись"));

    @AndroidFindBy(accessibility = "Повернутись")
    private WebElement backButton;

    public BankScreen(final AppiumDriver<?> driver) {
        super(driver);
    }

    @SneakyThrows
    public void tapBackButton() {
        getDriver().navigate().back();

//        isElementDisplayedLazy(backButton);
//        waitUntilClickable(backButton).click();
    }
}
