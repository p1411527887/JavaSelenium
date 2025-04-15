package BaiTap;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_TextBox_TextArea {
    WebDriver driver;
    String lastName , firstName ,fullName, email ,password, prefixEmail , postfixEmail ;
    Random random = new Random();

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        lastName = "truong";
        firstName = "phat";
        fullName = lastName + firstName;
        prefixEmail = "truonghongphat";
        postfixEmail = "@gmail.com";
        email = prefixEmail + random.nextInt(9999) + postfixEmail;
        password = "123456";




    }
    @Test
    public void TC_01_Regiter() throws InterruptedException {
        driver.get("https://live.techpanda.org/");
        WebElement myAcountLink = driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']"));
        myAcountLink.click();
        WebElement createAnAccountButton = driver.findElement(By.xpath("//a[@title='Create an Account']"));
        createAnAccountButton.click();
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@id='firstname']"));
        WebElement lastNameTextBox = driver.findElement(By.xpath("//input[@id='lastname']"));
        WebElement emailAddressTextBox = driver.findElement(By.xpath("//input[@id='email_address']"));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement confirmPasswordTextBox = driver.findElement(By.xpath("//input[@id='confirmation']"));
        WebElement signUpForNewsletterRadioButton = driver.findElement(By.xpath("//input[@id='is_subscribed']"));
        WebElement registerButton = driver.findElement(By.xpath("//span[text()='Register']"));

        firstNameTextBox.sendKeys(lastName);
        lastNameTextBox.sendKeys(firstName);
        passwordTextBox.sendKeys(password);
        emailAddressTextBox.sendKeys(email);
        confirmPasswordTextBox.sendKeys(password);
        signUpForNewsletterRadioButton.click();
        registerButton.click();

        Thread.sleep(2000);

        WebElement sendAnyWayButton = driver.findElement(By.xpath("//button[@id='proceed-button']"));

        sendAnyWayButton.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(),"Thank you for registering with Main Website Store.");

        String contactInformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInformationText.contains(firstName));

        WebElement mobileButton = driver.findElement(By.xpath("//a[text()='Mobile']"));
        mobileButton.click();
        WebElement samsunggalaxyProduct = driver.findElement(By.xpath("//h2//a[text()='Samsung Galaxy']"));
        samsunggalaxyProduct.click();

        WebElement addYourReviewLink = driver.findElement(By.xpath("//a[text()='Add Your Review']"));
        addYourReviewLink.click();
        WebElement fiveStarQualityRadioButton = driver.findElement(By.xpath("//label[@for='Quality 1_5']//input[@class='radio']"));
        fiveStarQualityRadioButton.click();

        WebElement letUsKnowYourThoughtTextArea = driver.findElement(By.xpath("//textarea[@id='review_field']"));
        letUsKnowYourThoughtTextArea.sendKeys("good job");

        WebElement summaryYourReviewTextBox = driver.findElement(By.xpath("//input[@id='summary_field']"));
        summaryYourReviewTextBox.sendKeys("good good");

        WebElement whatIsYourNameTextBox = driver.findElement(By.xpath("//input[@id='nickname_field']"));
        whatIsYourNameTextBox.sendKeys("truong hong phat");

        WebElement submitReviewButton =  driver.findElement(By.xpath("//span[text()='Submit Review']"));
        submitReviewButton.click();

        Thread.sleep(3000);

        WebElement sendAnyWayButton2 = driver.findElement(By.xpath("//button[@id='proceed-button']"));

        Thread.sleep(3000);
        sendAnyWayButton2.click();

        Thread.sleep(5000);
        String finalText = driver.findElement(By.xpath("//span[text()='Your review has been accepted for moderation.']")).getText();
        Assert.assertEquals(finalText,"Your review has been accepted for moderation.");


    }
    @Test
    public <string> void TC_02_Login() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String employeeID = Integer.toString(random.nextInt(9999));
        //Web element
        WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passWordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        //Action
        userNameTextBox.sendKeys("Admin");
        passWordTextBox.sendKeys("admin123");
        loginButton.click();
        Thread.sleep(2000);
        //Web element
        WebElement pimButton = driver.findElement(By.xpath("//span[text()='PIM']"));
        //Action
        pimButton.click();
        //Web element
        WebElement addEmloyeeButton = driver.findElement(By.xpath("//a[text()='Add Employee']"));
        //Action
        addEmloyeeButton.click();
        //Web element
        WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
        WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@name='firstName']"));
        WebElement lastnameTextBox = driver.findElement(By.xpath("//input[@name='lastName']"));
        WebElement employeeIDTextbox = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div"));
        //Action
        firstNameTextBox.sendKeys(firstName);
        lastnameTextBox.sendKeys(lastName);
        employeeIDTextbox.clear();

        employeeIDTextbox.sendKeys(employeeID);
        saveButton.click();








    }
    @AfterClass
    public void cleanBrower(){

        //driver.quit();
    }
}
