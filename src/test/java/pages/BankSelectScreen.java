package pages;

import io.appium.java_client.AppiumBy;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class BankSelectScreen extends  BaseAction{

   private WebElement selectBankScreenTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Оберіть свій банк']"));

    @SneakyThrows
    public boolean isSelectBankScreen() {
        return isElementDisplayedLazy(selectBankScreenTitle);
    }

    @SneakyThrows
    public void tapOnBankName(String bankName) {
        scrollAndClick(bankName);
    }

}
