package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_eily {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Regiter() throws InterruptedException {
        driver.get("https://testing.qa.prod.self-point.com/?domain=eliy.sites.self-point.com");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Accept all cookies']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Or select a store for pickup']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(text(),'Pickup Test')]/parent::div/following-sibling::button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='back to Login with email and password']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("qa-vn-ecom-01@stor.ai");
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("Abcd1234");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(), 'My Shopping Lists')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(), 'EBT-regression')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(), 'Check all')]")).click();
        driver.findElement(By.xpath("//div[text()='Add to cart']/parent::button")).click();
        driver.findElement(By.xpath("//span[text()='Checkout']/parent::button")).click();



    }
    @Test
    public void TC_02_Login(){

    }
    @AfterClass
    public void cleanBrower(){

        driver.quit();
    }
}
