package PageObjects;

import commons.AbstractPage;
import commons.Constants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;


    public RegisterPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public HomePageObject clickRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
        clickToElementByJS(driver, RegisterPageUI.REGISTER_BTN);
        return PageGeneratorManager.getHomePage(driver);
    }

    public boolean isMessageSuccessDisplayed(String value) {
        waitForElementVisible(driver, RegisterPageUI.MESSAGE_SUCCESS);
        return isControlDisplayed(driver, RegisterPageUI.MESSAGE_SUCCESS, value);
    }

    public void registerAccount() {
        inputIntoDynamicTextboxByJS(driver, "FirstName", Constants.FIRST_NAME);
        inputIntoDynamicTextboxByJS(driver, "LastName", Constants.FIRST_NAME);
        inputIntoDynamicTextboxByJS(driver, "Email", Constants.EMAIL);
        inputIntoDynamicTextboxByJS(driver, "Password", Constants.PASSWORD);
        inputIntoDynamicTextboxByJS(driver, "ConfirmPassword", Constants.PASSWORD);
    }
}