package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class LandingScreen extends BaseAction{


//    private WebElement landerTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Авторизація']"));

//    private WebElement bankIdButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='BankID']"));

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Авторизація']")
    private WebElement landerTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BankID']")
    private WebElement bankIdButton;

    public LandingScreen(final AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isLanderTitleDisplayed() {
        return isElementDisplayedLazy(landerTitle);
    }

    public void tapBankIdButton() {
        waitUntilClickable(bankIdButton).click();
    }
}
