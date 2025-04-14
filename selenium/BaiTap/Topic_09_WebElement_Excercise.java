package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Topic_09_WebElement_Excercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
    public void TC_01_IsDisplayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
        if (emailTextBox.isDisplayed()){
            System.out.println("emailTextBox Element is displayed");
            emailTextBox.sendKeys("truonghongphattvn@gmail.com");
        } else {
            System.out.println("Element is NOT displayed");
        };

        WebElement educationTextarea = driver.findElement(By.xpath("//textarea[@id='edu']"));
        if (educationTextarea.isDisplayed()){
            System.out.println("educationTextarea Element is displayed");
            educationTextarea.sendKeys("nguyen tat thanh");
        } else {
            System.out.println("Element is NOT displayed");
        };

        WebElement under18RadioCheckbox = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (under18RadioCheckbox.isDisplayed()){
            System.out.println("under18RadioCheckbox Element is displayed");
            under18RadioCheckbox.click();
        } else {
            System.out.println("Element is NOT displayed");
        };


        WebElement h5UserName = driver.findElement(By.xpath("//h5[text()='Name: User5']"));

        if (h5UserName.isDisplayed()){
            System.out.println("H5 Element is displayed");
        } else {
            System.out.println("H5 Element is not displayed");
        };

    }
    @Test
    public void TC_02_Enable(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='mail']"));
        WebElement under18RadioCheckbox = driver.findElement(By.xpath("//input[@id='under_18']"));
        if(emailTextBox.isEnabled()){
            System.out.println("email text box is enable");
        }else {
            System.out.println("email text box is not enable");
        };

        WebElement passWordTextBox = driver.findElement(By.xpath("//input[@id='disable_password']"));
        WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='radio-disabled']"));

        if(passWordTextBox.isEnabled()){
            System.out.println("passwordTextBox is disable");
        }else {
            System.out.println("passwordTextBox is not disable");
        };

    }@Test
    public void TC_03_Selected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement under18RadioCheckbox = driver.findElement(By.xpath("//input[@id='under_18']"));
        if(under18RadioCheckbox.isSelected()){
            System.out.println("18RadioCheckbox is selected");
        }else {
            System.out.println("18RadioCheckbox is not selected");
        };

        under18RadioCheckbox.click();

        if (under18RadioCheckbox.isSelected()){
            System.out.println("18RadioCheckbox is selected");
        }else {
            System.out.println("18RadioCheckbox is not selected");
        };

    }@Test
    public void TC_04_Register_Function(){
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("p1411527888@gmail.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("1234");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("abcd");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());

        driver.findElement(By.xpath("//input[@id='new_password']")).clear();
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("ABCD");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());


    }
    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
