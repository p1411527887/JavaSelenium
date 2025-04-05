package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiTap_02_1_Locator_Priority {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/login");
    }
    @Test
    public void TC_01_Locator_Priority(){
        // áp dụng quy tắc tối ưu locator để tìm Email textbox
        //input[@class='email'] (duy nhất )
        //input[@id='Email'] (duy nhất )
        //input[@name='Email'] (duy nhất )
        // => chọn cai nào cũng được
        driver.findElement(By.xpath("//input[@class='email']"));

        // áp dụng quy tắc tối ưu locator để tìm RememberMe checkbox
        //input[@id='RememberMe'] (duy nhất )
        //input[@name='RememberMe'] ( có 2 cái )
        //=> chọn cái //input[@id='RememberMe']
        driver.findElement(By.xpath("//input[@id='RememberMe']"));
    }

    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
