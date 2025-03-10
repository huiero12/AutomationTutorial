package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebTableTests extends SharedData {

    @Test
    public void MetodaTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        //deschidem un browser
        driver = new ChromeDriver();

        //accesam o pagina web
        driver.get("https://demoqa.com/webtables");

        //facem browser-ul in modul maximize
        driver.manage().window().maximize();


        WebElement elementsMenu = driver.findElement(By.xpath("//h5[text()='Elements']"));
        executor.executeScript("arguments[0].click();", elementsMenu);

        WebElement webTableSubMenu = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        executor.executeScript("arguments[0].click();", webTableSubMenu);

        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 3, "Valoarea initiala a tabelului nu este 3");

        //identificam un element
        WebElement addElement = driver.findElement(By.id("addNewRecordButton"));
        executor.executeScript("arguments[0].click();", addElement);

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "Huiet";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue = "Roxana";
        lastNameElement.sendKeys(lastNameValue);

        WebElement userEmailElement = driver.findElement(By.id("userEmail"));
        String userEmailvalue = "huiet.roxana@gmail.com";
        userEmailElement.sendKeys(userEmailvalue);

        WebElement ageElement = driver.findElement(By.id("age"));
        String ageValue = "37";
        ageElement.sendKeys(ageValue);

        WebElement salaryElement = driver.findElement(By.id("salary"));
        String salaryValue = "2000";
        salaryElement.sendKeys(salaryValue);

        WebElement departmentElement = driver.findElement(By.id("department"));
        String departmentValue = "none";
        departmentElement.sendKeys(departmentValue);

        WebElement submitElement = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement);

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        String expectedRow = tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(userEmailvalue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));

        //edit functionality
        WebElement editElement = driver.findElement(By.id("edit-record-4"));
        executor.executeScript("arguments[0].click();", editElement);

        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Popescu";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editLastNameElement = driver.findElement(By.id("lastName"));
        String editLastNameValue = "Alina";
        editLastNameElement.clear();
        editLastNameElement.sendKeys(editLastNameValue);

        WebElement userEmailElement2 = driver.findElement(By.id("userEmail"));
        String userEmailValue2 = "alina.popescu@yahoo.com";
        userEmailElement2.clear();
        userEmailElement2.sendKeys(userEmailValue2);

        WebElement ageElement2 = driver.findElement(By.id("age"));
        String ageValue2 = "20";
        ageElement2.clear();
        ageElement2.sendKeys(ageValue2);

        WebElement salaryElement2 = driver.findElement(By.id("salary"));
        String salaryValue2 = "20";
        salaryElement2.clear();
        salaryElement2.sendKeys(salaryValue2);

        WebElement departmentElement2 = driver.findElement(By.id("department"));
        String departmentValue2 = "IT";
        departmentElement2.clear();
        departmentElement2.sendKeys(departmentValue2);

        WebElement submitElement2 = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].click();", submitElement2);

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        expectedRow = tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        Assert.assertTrue(expectedRow.contains(editLastNameValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue2));
        Assert.assertTrue(expectedRow.contains(ageValue2));
        Assert.assertTrue(expectedRow.contains(salaryValue2));
        Assert.assertTrue(expectedRow.contains(departmentValue2));

        WebElement deleteElement = driver.findElement(By.id("delete-record-4"));
        deleteElement.click();

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4, "Valoarea actuala a tabelului nu este 4");

    }
}
