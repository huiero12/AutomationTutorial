package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class SharedData {
    //Aceasta clasa are ca rol sa deschida/inchida un browser
//Vom face acest lucru folosind adnotari de testNG
//before suite / before test / before class / before method / test
// continues after test with: after method / after class / after test / after suite
    public WebDriver driver;

    @BeforeTest
    public void prepareEnvironment() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearEnvironment() {
        driver.quit();

    }
}
