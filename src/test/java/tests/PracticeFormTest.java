package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void MetodaTest() {

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        By formsMenu = By.xpath("//h5[text()='Forms']");
        executor.executeScript("arguments[0].click();", formsMenu);

        By practiceForm = By.xpath("//span[text()='Practice Form']");
        executor.executeScript("arguments[0].click();", practiceForm);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Huiet";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Roxana";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "huiet.roxana@gmail.com";
        elementHelper.fillLocator(emailElement, emailValue);


        String genderValue = "Female";
        List<WebElement> genderOptionsList = driver.findElements(By.xpath("//input[@name='gender']"));
        if (genderValue.equals("Male")) {
            executor.executeScript("arguments[0].click();", genderOptionsList.get(0));
        }

        if (genderValue.equals("Female")) {
            executor.executeScript("arguments[0].click();", genderOptionsList.get(1));
        }

        if (genderValue.equals("Other")) {
            executor.executeScript("arguments[0].click();", genderOptionsList.get(2));
        }
        By mobilePhoneElement = By.xpath("//input[@placeholder='Mobile Number']");
        String mobilePhoneValue = "0754857977";
        elementHelper.fillLocator(mobilePhoneElement, mobilePhoneValue);

        executor.executeScript("window.scrollBy(0,500)", "");

        WebElement subjectsElement = driver.findElement(By.id("subjectsInput"));
        executor.executeScript("arguments[0].click();", subjectsElement);
        //String subjectsValue = "Maths";
        //subjectsElement.sendKeys(subjectsValue);
        //subjectsElement.sendKeys(Keys.ENTER);
        //String subjectsValue2 = "Art";
        //subjectsElement.sendKeys(subjectsValue2);
        //subjectsElement.sendKeys(Keys.ENTER);


        //trebuie sa fac o lista de string-uri si sa adaug elementele pe care doresc sa le selectez
        //trebuie sa parcurg lista pe care am facut-o cu un "for"
        //in interiorul "for-ului" trebuie sa completez pe rand fiecare valoare in "subjectsElement" si apoi sa apas un "enter"


        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");

//        for (int index = 0; index < subjects.size(); index++) {
//            subjectsElement.sendKeys(subjects.get(index));
//            subjectsElement.sendKeys(Keys.ENTER);
        ElementHelper.fillPressLocator(subjectElement, subjects.get(index), Keys.ENTER);
    }

    List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Music");

    List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for(
    int index = 0; index<hobbiesOptionList.size();index++)

    {
        String currentText = hobbiesOptionList.get(index).getText();

        if (hobbies.contains(currentText)) {
            executor.executeScript("arguments[0].click();", hobbiesOptionList.get(index));
        }
    }

    By pictureElement = By.id("uploadPicture");
    File file = new File("src/test/resources/AnimalLover.jpg");
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

    By addressElement = By.id("currentAddress");
    String addressValue = "Timisoara";
       elementHelper.fillLocator(addressElement,addressValue);

    By stateElement = By.xpath("//div[text()='Select State']");
        executor.executeScript("arguments[0].click();",stateElement);

    By stateInputElement = By.id("react-select-3-input");
    String stateInputValue = "NCR";
        elementHelper.fillPressLocator(stateInputElement,stateValue,Keys.ENTER);

    By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

    By cityInputElement = By.id("react-select-4-input");
    String cityInputValue = "Delhi";
        elementHelper.fillPressLocator(CityInputElement,cityValue,Keys.ENTER);

    By submitElement = By.id("submit");
        elementHelper.clcikLocator(submitElement);

    //pana aici am ajuns astazi 26.02.2026
    //homework -> test WebTable -> sa facem ce a facut Florentina, un element helper, sa modificam ce e cu send.keys etc
    //assert si validarile nu le facem nimic.

    WebElement thankyouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
    String expectedMessage = "Thanks for submitting the form";
    String actualMessage = thankyouElement.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        System.out.println("Testul a fost validat");

    List<WebElement> tablesRowsList = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(tablesRowsList.get(0).

    getText().

    contains("Student Name"));
        Assert.assertTrue(tablesRowsList.get(0).

    getText().

    contains(firstNameValue));
        Assert.assertTrue(tablesRowsList.get(0).

    getText().

    contains(lastNameValue));

        Assert.assertTrue(tablesRowsList.get(1).

    getText().

    contains("Student Email"));
        Assert.assertTrue(tablesRowsList.get(1).

    getText().

    contains(emailValue));

        Assert.assertTrue(tablesRowsList.get(2).

    getText().

    contains("Gender"));
        Assert.assertTrue(tablesRowsList.get(2).

    getText().

    contains(genderValue));

        Assert.assertTrue(tablesRowsList.get(3).

    getText().

    contains("Mobile"));
        Assert.assertTrue(tablesRowsList.get(3).

    getText().

    contains(mobilePhoneValue));

        Assert.assertTrue(tablesRowsList.get(5).

    getText().

    contains("Subjects"));
        Assert.assertTrue(tablesRowsList.get(5).

    getText().

    contains("Maths"));
        Assert.assertTrue(tablesRowsList.get(5).

    getText().

    contains("Arts"));
        Assert.assertTrue(tablesRowsList.get(5).

    getText().

    contains("Biology"));
        Assert.assertTrue(tablesRowsList.get(5).

    getText().

    contains("Chemistry"));

        Assert.assertTrue(tablesRowsList.get(6).

    getText().

    contains("Hobbies"));
        Assert.assertTrue(tablesRowsList.get(6).

    getText().

    contains("Sports"));
        Assert.assertTrue(tablesRowsList.get(6).

    getText().

    contains("Reading"));

        Assert.assertTrue(tablesRowsList.get(7).

    getText().

    contains("Picture"));
        Assert.assertTrue(tablesRowsList.get(7).

    getText().

    contains("2022-12-14 (1).png"));

        Assert.assertTrue(tablesRowsList.get(8).

    getText().

    contains("Address"));
        Assert.assertTrue(tablesRowsList.get(8).

    getText().

    contains(addressValue));

        Assert.assertTrue(tablesRowsList.get(9).

    getText().

    contains("State and City"));
        Assert.assertTrue(tablesRowsList.get(9).

    getText().

    contains(stateInputValue));
        Assert.assertTrue(tablesRowsList.get(9).

    getText().

    contains(cityInputValue));
}
}