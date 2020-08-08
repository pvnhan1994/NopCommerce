package account;

import PageObjects.MainPageObject;
import PageObjects.RegisterPageObject;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class id001_validateRegisterPage extends AbstractTest {
    WebDriver driver;
    RegisterPageObject registerPage;
    MainPageObject mainPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = PageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
    }

    @Test
    public void TC01_EmptyData() {
        log.info("Step 1: Click Register button");
        registerPage.clickRegisterButton();

        log.info("Step 2.1: Verify validate message First Name");
        verifyEquals("First name is required.", registerPage.getDynamicValidate(driver, "FirstName-error"));

        log.info("Step 2.2: Verify validate message Last Name");
        verifyEquals("Last name is required.", registerPage.getDynamicValidate(driver, "LastName-error"));

        log.info("Step 2.3: Verify validate message Email");
        verifyEquals("Email is required.", registerPage.getDynamicValidate(driver, "Email-error"));

        log.info("Step 2.4: Verify validate message Password");
        verifyEquals("Password is required.", registerPage.getDynamicValidate(driver, "Password-error"));

        log.info("Step 2.5: Verify validate message Confirm Password");
        verifyEquals("Password is required.", registerPage.getDynamicValidate(driver, "ConfirmPassword-error"));

    }

    @Test
    public void TC02_InvalidMail() {
        log.info("Step 1: Input invalid Email");
        registerPage.inputIntoDynamicTextbox(driver, "Email", "321321");

        log.info("Step 2: Verify validate message Email");
        verifyEquals("Wrong email", registerPage.getDynamicValidate(driver, "Email-error"));

    }

    @Test
    public void TC04_PasswordLessThan6Chars() {
        log.info("Step 1: Input password less than 6 chars");
        registerPage.inputIntoDynamicTextbox(driver, "Password", "123");

        log.info("Step 3: Verify validate message Password");
        verifyEquals("Password must meet the following rules:\n" +
                "must have at least 6 characters", registerPage.getDynamicValidate(driver, "Password-error"));
    }

    @Test
    public void TC05_ConfirmPasswordDoNotMatch() {
        log.info("Step 1: Input valid password");
        registerPage.inputIntoDynamicTextbox(driver, "Password", "123456");

        log.info("Step 2: Input confirm password do not match");
        registerPage.inputIntoDynamicTextbox(driver, "ConfirmPassword", "123");

        log.info("Step 3: Verify validate message Confirm Password");
        verifyEquals("The password and confirmation password do not match.", registerPage.getDynamicValidate(driver, "ConfirmPassword-error"));
    }

    @Test
    public void TC06_InputAllValidData() {
        log.info("Step 1: Input First Name");
        registerPage.inputIntoDynamicTextbox(driver, "FirstName", Constants.FIRST_NAME);

        log.info("Step 2: Input Last Name");
        registerPage.inputIntoDynamicTextbox(driver, "LastName", Constants.LAST_NAME);

        log.info("Step 3: Input Email");
        registerPage.inputIntoDynamicTextbox(driver, "Email", Constants.EMAIL);

        log.info("Step 4: Input Password");
        registerPage.inputIntoDynamicTextbox(driver, "Password", Constants.PASSWORD);

        log.info("Step 5: Input Confirm Password");
        registerPage.inputIntoDynamicTextbox(driver, "ConfirmPassword", Constants.PASSWORD);

        log.info("Step 6: Click Register Button");
        registerPage.clickRegisterButton();

        log.info("Step 7: Message success displayed");
        verifyTrue(registerPage.isMessageSuccessDisplayed("Your registration completed"));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

}
