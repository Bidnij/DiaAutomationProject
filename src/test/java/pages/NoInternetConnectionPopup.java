package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class NoInternetConnectionPopup extends BaseAction{

//    private WebElement noInternetTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Немає інтернету']"));
//    private WebElement noInternetBodyText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Перевірте з’єднання та спробуйте ще раз']"));
//    private WebElement tryAgainButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Спробувати ще']"));

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Немає інтернету']")
    private WebElement noInternetTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Перевірте з’єднання та спробуйте ще раз']")
    private WebElement noInternetBodyText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Спробувати ще']")
    private WebElement tryAgainButton;

    public NoInternetConnectionPopup(final AppiumDriver<?> driver) {
        super(driver);
    }

    public boolean isNoInternetTitleDisplayed() {
        return isElementDisplayedLazy(noInternetTitle);
    }

    public boolean isNoInternetBodyTextDisplayed() {
        return isElementDisplayedLazy(noInternetBodyText);
    }

    public boolean isTryAgainButtonDisplayed() {
        return isElementDisplayedLazy(tryAgainButton);
    }

}
