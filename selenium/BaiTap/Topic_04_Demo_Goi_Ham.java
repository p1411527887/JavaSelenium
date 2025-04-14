package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Demo_Goi_Ham {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/login");
    }
    @Test
    public void TC_01_Regiter(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(15));

        driver.manage().window().fullscreen();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();
        driver.manage().window().maximize();
        driver.manage().window().minimize();




    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
