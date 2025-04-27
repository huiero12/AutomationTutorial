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

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.indexPage;

public class BrowserWindowTest extends SharedData {

    @Test
    public void MetodaTest() {
        TabWindowHelper tabWindowHelper = new TabWindowHelper(driver);

        ElementHelper elementHelper = new ElementHelper(driver);

        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubMenu();

        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertFrameWindowsMenu);

        By browserSubMenu = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickJSLocator(browserSubMenu);

        By tabButtonElement = By.id("tabButton");
        elementHelper.clickJSLocator(tabButtonElement);

        System.out.println(driver.getCurrentUrl());

        // List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//driver.switchTo().window(tabs.get(1));

        tabWindowHelper.switchToSpecificTabWindow(1);

        System.out.println(driver.getCurrentUrl());

        //inchide tab-ul curent
//driver.close();

        tabWindowHelper.switchToSpecificTabWindow(0);

        By newWindowClickElement = By.id("windowButton");
        elementHelper.clickLocator(newWindowClickElement);

        tabWindowHelper.switchToSpecificTabWindow(1);

        System.out.println(driver.getCurrentUrl());

        //pentru a ramane deschise ambele taburi
//List<String> windows = new ArrayList<>(driver.getWindowHandles());
//driver.switchTo().window(windows.get(1));

    }
}
