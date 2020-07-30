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
    public void beforeClass(){


        System.setProperty(Setting.CHROME_DRIVER_PROP, Setting.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01() {
        WebElement hover = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]"));
        Actions action = new Actions(driver);
        action.moveToElement(hover).perform();
        WebElement product = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'Desktops')]"));
        Assert.assertTrue(product.isDisplayed());
     //   product.click();

        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", product);

        driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("dsadsadsadsajdsal;dskajel;wqkejwqlp;ekwjqe;wlqkdjs;alkdjsa;ldkjqw;elqkje;lksdja;lsdkajds;akewq;k");


    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
