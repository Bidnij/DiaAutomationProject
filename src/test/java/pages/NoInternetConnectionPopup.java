package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

public class NoInternetConnectionPopup extends BaseAction{

    private WebElement noInternetTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Немає інтернету']"));
    private WebElement noInternetBodyText = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Перевірте з’єднання та спробуйте ще раз']"));
    private WebElement tryAgainButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Спробувати ще']"));

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
