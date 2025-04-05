package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaiTap02_Demo_RelativeLocator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Demo_Relative_Locator(){
        WebElement newsLink = driver.findElement(By.xpath("//a[text()='News']"));
        WebElement recenlyViewProductLink = driver.findElement(By.xpath("//a[text()='Recently viewed products']"));
        WebElement privacyNoticeLink = driver.findElement(By.xpath("//a[text()='Privacy notice']"));
        WebElement addressesLink = driver.findElement(By.xpath("//a[text()='Addresses']"));

        driver.findElement(RelativeLocator.with(By.tagName("a"))// tim Blog Link của customer service
                .above(recenlyViewProductLink)
                .below(newsLink)
                .toRightOf(privacyNoticeLink)
                .toLeftOf(addressesLink));
    }

    @AfterClass
    public void cleanBrower(){
        driver.quit();
    }
}
