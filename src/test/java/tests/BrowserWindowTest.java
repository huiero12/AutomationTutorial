package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowTest extends SharedData {


    @Test
    public void MetodaTest() {
        TabWindowHelper tabWindowHelper = new TabWindowHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);

        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        ElementHelper.clickJSLocator(alertFrameWindowsMenu);

        By browserWindowsSubmenu = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickLocator(browserWindowsSubmenu);

        By newTabElement = By.id("tabButton");
        elementHelper.clickLocator(newTabElement);


        System.out.println(driver.getCurrentUrl());

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        System.out.println(driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(tabs.get(0));
        WebElement newWindowClickElement = driver.findElement(By.id("windowButton"));
        executor.executeScript("arguments[0].click();", newWindowClickElement);

        driver.switchTo().window(tabs.get(1));
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driver.getCurrentUrl());

        driver.close();

    }
}
