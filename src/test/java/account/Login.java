package account;

import PageObjects.HomePageObject;
import PageObjects.RegisterPageObject;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class Login extends AbstractTest {
    WebDriver driver;
    RegisterPageObject registerPage;
    HomePageObject homePage;

    @Parameters("browser")
    @BeforeMethod
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = homePage.clickRegisterItem();
    }
    @Test
    public void TC01_EmptyData(){
        log.info("Step 1: Click Register Button");
        registerPage.clickRegisterButton();

        log.info("Step 2.1: Verify validate message First Name");
        verifyEquals("First name is required.",registerPage.getDynamicValidate(driver,"FirstName-error"));

        log.info("Step 2.2: Verify validate message Last Name");
        verifyEquals("Last name is required.",registerPage.getDynamicValidate(driver,"LastName-error"));

        log.info("Step 2.3: Verify validate message Email");
        verifyEquals("Email is required.",registerPage.getDynamicValidate(driver,"Email-error"));

        log.info("Step 2.4: Verify validate message Password");
        verifyEquals("Password is required.",registerPage.getDynamicValidate(driver,"Password-error"));

        log.info("Step 2.5: Verify validate message Confirm Password");
        verifyEquals("Password is required.",registerPage.getDynamicValidate(driver,"ConfirmPassword-error"));

    }
    
    @AfterMethod (alwaysRun = true)
    public void afterClass(){

        driver.quit();
    }

}
