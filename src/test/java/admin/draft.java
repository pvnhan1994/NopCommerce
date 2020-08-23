package admin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import commons.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class draft {
    WebDriver driver;
    JavascriptExecutor javascriptExecutor;
    WebDriverWait waitExplicit;

    @BeforeClass
    public void beforeClass() {
        System.setProperty(Setting.CHROME_DRIVER_PROP, Setting.CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        javascriptExecutor = (JavascriptExecutor) driver;
        waitExplicit = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_06_VueJS() throws Exception {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        String arr[] = {"Second Option","First Option"};
        selectMultiItemInDropdown("//div[@id='app']/div/li/span", "//ul[@class='dropdown-menu']//a", "abc", arr);


    } public void selectMultiItemInDropdown( String parentXpath, String allItemXpath,String itemSelected, String[] expectedValueItem) throws Exception {
        // click vao dropdown tat ca value
        WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
        javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
        // cho value load ra
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
        System.out.println("Tat ca phan tu trong dropdown =" + allItems.size());
        for (WebElement childElement : allItems) {
            System.out.println("ChildElementt111: " +  childElement.getText());
        }
        // duyet qua het tat ca cac phan tu
        for (WebElement childElement : allItems) {


            for (String item : expectedValueItem) {
                System.out.println("item: "+ item);
                if (childElement.getText().equals(item)) {
                    System.out.println("Child gettext: "+ childElement.getText());
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    Thread.sleep(1500);

                    javascriptExecutor.executeScript("arguments[0].click();", childElement);
                    Thread.sleep(1500);

                    List<WebElement> it = driver.findElements(By.xpath(itemSelected));
                    System.out.println("Item selected = " + it.size());
                    if (expectedValueItem.length == it.size()) {
                        break;
                    }

                }
            }
        }
    }


}
