package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://www.shop.netcostmarket.com/");
    }
    @Test
    public void TC_01_Regiter(){
        driver.findElement(By.xpath("//a[@ng-click='chooseAreaCtrl.filterAreas.pickup();']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Choose Bustleton Ave - 11701 Bustleton Ave, Philadelphia, PA']")).click();
        driver.findElement(By.xpath("//button[@class='no-design login']"));

    }

    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
