package account;

import PageObjects.HomePageObject;
import PageObjects.MainPageObject;
import PageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class validateLoginPage extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    LoginPageObject loginPage;
    HomePageObject homePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = PageGeneratorManager.getMainPage(driver);
        loginPage = mainPage.clickLoginItem();
    }

    @Test
    public void TC01_EmptyData() {
        log.info("Step 1: Click Login button");
        loginPage.clickToLoginButton();

        log.info("Step 2: Verify error msg displayed");
        verifyEquals("Please enter your email",loginPage.getDynamicValidate(driver,"Email-error"));
    }

    @Test
    public void TC02_InvalidEmail() {
        log.info("Step 1: Input invalid Email");
        loginPage.inputIntoDynamicTextbox(driver,"Email", "abc");

        log.info("Step 2:");
        verifyEquals("Wrong email",loginPage.getDynamicValidate(driver,"Email-error"));
    }

    @Test
    public void TC03_EmailUnregister() {
        log.info("Step 1: Input Email Unregister");
        loginPage.inputIntoDynamicTextbox(driver,"Email", "abdsadsac@gmail.com");

        log.info("Step 2: Click Login button");
        loginPage.clickToLoginButton();

        log.info("Step 3: Error Msg displayed");
        verifyTrue(loginPage.isErrorMessageDisplayed("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"));
    }

    @Test
    public void TC04_EmailRegisteredAndEmptyPassword() {
        log.info("Step 1: Input Email Registered");
        loginPage.inputIntoDynamicTextbox(driver,"Email", "abds12adsac@gmail.com");

        log.info("Step 2: Click Login button");
        loginPage.clickToLoginButton();

        log.info("Step 3: Error Msg displayed");
        verifyTrue(loginPage.isErrorMessageDisplayed("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"));
    }

    @Test
    public void TC05_EmailRegisteredAndIncorrectPassword() {
        log.info("Step 1: Input Email Registered");
        loginPage.inputIntoDynamicTextbox(driver,"Email", "binvnese@gmail.com");

        log.info("Step 2: Input Password Incorrect");
        loginPage.inputIntoDynamicTextbox(driver,"Password", "abds12adsac@gmail.com");

        log.info("Step 3: Click Login button");
        loginPage.clickToLoginButton();

        log.info("Step 4: Error Msg displayed");
        verifyTrue(loginPage.isErrorMessageDisplayed("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"));
    }

    @Test
    public void TC06_EmailRegisteredAndCorrectPassword() {
        log.info("Step 1: Input Email Registered");
        loginPage.inputIntoDynamicTextbox(driver,"Email", "binvnese@gmail.com");

        log.info("Step 2: Input Password Correct");
        loginPage.inputIntoDynamicTextbox(driver,"Password", "123123");

        log.info("Step 3: Click Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Step 4: Login success - My Account Item displayed");
        verifyTrue(homePage.isMyAccountItemDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
