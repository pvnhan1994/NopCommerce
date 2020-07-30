package account;

import commons.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class draft {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass() {


        System.setProperty(Setting.CHROME_DRIVER_PROP, Setting.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01() {
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Phan ");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Viet ");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("binvnese2341@gmail.com");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123123");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123123");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
