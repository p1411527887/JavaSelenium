package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiTap_01_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_locatorById(){
        driver.findElement(By.id("FirstName"));
        driver.findElement(By.id("LastName"));
        driver.findElement(By.id("Email"));
    }
    @Test
    public void TC_02_locatorByClass(){
        driver.findElement(By.className("search-box-button"));
        driver.findElement(By.className("register-next-step-button"));
        driver.findElement(By.className("newsletter-subscribe-button"));
    }
    @Test
    public void TC_03_locatorByName(){
        driver.findElement(By.name("Company"));
        driver.findElement(By.name("Password"));

    }
    @Test
    public void TC_04_locatorByLinkText(){
        driver.findElement(By.linkText("Sitemap"));
        driver.findElement(By.linkText("Shipping & returns"));

    }
    @Test
    public void TC_05_locatorByPartialLinkText(){
        // co the lay toan bo text hoac 1 phan ( hay dung)
        driver.findElement(By.partialLinkText("Shopping"));
        driver.findElement(By.partialLinkText("Apply for vendor"));

    }
    @Test
    public void TC_06_locatorByTagName(){
        // dung de tim cac component giong nhau
        driver.findElement(By.tagName("button"));
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_07_locatorByCss(){
        driver.findElement(By.cssSelector("input#ConfirmPassword"));
        driver.findElement(By.cssSelector("input#Company"));
        driver.findElement(By.cssSelector("input#FirstName"));
    }
    @Test
    public void TC_08_locatorByXpath(){
        driver.findElement(By.xpath("//input[@id='Newsletter']"));
        driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));

    }

    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
