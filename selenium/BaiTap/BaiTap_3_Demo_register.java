package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaiTap_3_Demo_register {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @Test
    public void _Emplty_Data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        dangKyButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText(),"Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Vui lòng nhập số điện thoại.");

    }

    @Test
    public void TC_02_Regiter_With_Invalid_Data(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        hoVaTenTextBox.sendKeys("Truong Hong Phat");
        diaChiEmailTextBox.sendKeys("qưert");
        nhapLaiEmailTextBox.sendKeys("qưert");
        matKhauTextBox.sendKeys("123456");
        nhapLaiMatKhauTextBox.sendKeys("122456");
        dienThoaiTextBox.sendKeys("0915866160");
        dangKyButton.click();

        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText(),"Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");


    };

    @Test
    public void TC_03_Regiter_With_Incorrect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        hoVaTenTextBox.sendKeys("Truong Hong Phat");
        diaChiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        nhapLaiEmailTextBox.sendKeys("qưert");
        matKhauTextBox.sendKeys("123456");
        nhapLaiMatKhauTextBox.sendKeys("123456");
        dienThoaiTextBox.sendKeys("0915866160");

        dangKyButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");


    };


    @Test
    public void TC_04_Regiter_With_Password_Lower_6_character(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        hoVaTenTextBox.sendKeys("Truong Hong Phat");
        diaChiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        nhapLaiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        matKhauTextBox.sendKeys("12345");
        nhapLaiMatKhauTextBox.sendKeys("12345");
        dienThoaiTextBox.sendKeys("0915866160");

        dangKyButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");


    };

    @Test
    public void TC_05_Regiter_With_Incorrect_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        hoVaTenTextBox.sendKeys("Truong Hong Phat");
        diaChiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        nhapLaiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        matKhauTextBox.sendKeys("123456");
        nhapLaiMatKhauTextBox.sendKeys("123457");
        dienThoaiTextBox.sendKeys("0915866160");

        dangKyButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText(),"Mật khẩu bạn nhập không khớp");



    };


    @Test
    public void TC_06_Regiter_Invalid_Phone_Number(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        WebElement hoVaTenTextBox = driver.findElement(By.xpath("//input[@id='txtFirstname']"));
        WebElement diaChiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtEmail']"));
        WebElement nhapLaiEmailTextBox = driver.findElement(By.xpath("//input[@id='txtCEmail']"));
        WebElement matKhauTextBox = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        WebElement nhapLaiMatKhauTextBox = driver.findElement(By.xpath("//input[@id='txtCPassword']"));
        WebElement dienThoaiTextBox = driver.findElement(By.xpath("//input[@id='txtPhone']"));
        WebElement dangKyButton = driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']"));

        hoVaTenTextBox.sendKeys("Truong Hong Phat");
        diaChiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        nhapLaiEmailTextBox.sendKeys("truonghongphattvn@gmail.com");
        matKhauTextBox.sendKeys("123456");
        nhapLaiMatKhauTextBox.sendKeys("123456");
        dienThoaiTextBox.sendKeys("1915866160");

        dangKyButton.click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");



    };

    @AfterClass
    @Test
    public void cleanBrowser(){
        driver.quit();
    }
};


