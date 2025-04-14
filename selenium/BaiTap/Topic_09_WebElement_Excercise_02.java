package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_09_WebElement_Excercise_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void TC_01_Login_With_Empty_Email_And_Password() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));

        loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");

    }
    @Test
    public void TC_02_Login_With_Invalid_Email() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
        WebElement emailAdressTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='pass']"));

        emailAdressTextBox.sendKeys("1234564@123.123");
        passwordTextBox.sendKeys("123456");
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),"Please enter a valid email address. For example johndoe@domain.com.");


    }

    @Test
    public void TC_03_Login_Lower_6_Characters() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
        WebElement emailAdressTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='pass']"));
        emailAdressTextBox.sendKeys("p1411527887@gmail.com");
        passwordTextBox.sendKeys("12345");
        loginButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");


    }

    @Test
    public void TC_04_Login_With_Incorrect_Email_ANd_Password() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']")).click();
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='send2']"));
        WebElement emailAdressTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='pass']"));
        emailAdressTextBox.sendKeys("automation@gmail.com");
        passwordTextBox.sendKeys("123123123");
        loginButton.click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");

    }
    @AfterClass
    public void cleanBrower(){

        driver.quit();
    }
}
