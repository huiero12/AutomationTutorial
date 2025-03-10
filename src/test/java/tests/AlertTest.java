package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void MetodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);

        By alertFrameWindowMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        ElementHelper.clickJSLocator(alertFrameWindowMenu);

        By alertsSubmenu = By.xpath("//span[text()='Alerts']");
        elementHelper.clickLocator(alertsSubmenu);

        By alertOkElement = By.id("alertButton");
        elementHelper.clickLocator(alertOkElement);

        //aceasta este o noua metoda
        Alert alertOk = driver.switchTo().alert();

        //daca folosim a aceasta metoda, ne va afisa ca am apasat pe buton
        System.out.println(alertOk.getText());
        alertOk.accept();

        By timerAlertElement = By.id("timerAlertButton");
        elementHelper.clickLocator(timerAlertElement);

        alertHelper.acceptAlert();

        alertHelper.acceptAlert();

        By confirmElement = By.id("confirmButton");
        elementHelper.clickLocator(confirmElement);

        alertHelper.cancelAlert();

        By promtElement = By.id("promtButton");
        elementHelper.clickLocator(promtElement);

        alertHelper.fillAlert("Sunny day");

    }
}
