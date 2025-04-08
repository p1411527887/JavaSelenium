package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiNhap {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://www.shop.netcostmarket.com/specials");
    }
    @Test
    public void TC_01_Regiter(){
        driver.findElement(By.xpath("Topic_00_Template"));
    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
