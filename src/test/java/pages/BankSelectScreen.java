package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BankSelectScreen extends  BaseAction{

//   private WebElement selectBankScreenTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Оберіть свій банк']"));

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Оберіть свій банк']")
    private WebElement selectBankScreenTitle;

    public BankSelectScreen(final AppiumDriver<?> driver) {
        super(driver);
    }

    @SneakyThrows
    public boolean isSelectBankScreen() {
        return isElementDisplayedLazy(selectBankScreenTitle);
    }

    @SneakyThrows
    public void tapOnBankName(String bankName) {
        scrollAndClick(bankName);
    }

}
