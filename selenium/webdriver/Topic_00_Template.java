package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/login");
    }
    @Test
    public void TC_01_Regiter(){

    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void cleanBrower(){

        driver.quit();
    }
}
