package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    String email = "binvnese@gmail.com";
    String firstName = "Nhan";
    String lastName = "Phan";
    public RegisterPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public HomePageObject clickRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
        // clickToElement(driver, RegisterPageUI.REGISTER_BTN);
        clickToElementByJS(driver, RegisterPageUI.REGISTER_BTN);
        return PageGeneratorManager.getHomePage(driver);
    }

    public boolean isMessageSuccessDisplayed(String value) {
        waitForElementVisible(driver, RegisterPageUI.MESSAGE_SUCCESS);
        return isControlDisplayed(driver, RegisterPageUI.MESSAGE_SUCCESS,value);
    }
    public void registerAccount() {
        System.out.println("id Driver 1: " + driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.inputIntoDynamicTextbox(driver, "FirstName", firstName);
        registerPage.inputIntoDynamicTextbox(driver, "LastName", lastName);
        registerPage.inputIntoDynamicTextbox(driver, "Email", email);
        registerPage.inputIntoDynamicTextbox(driver, "Password", "123123");
        registerPage.inputIntoDynamicTextbox(driver, "ConfirmPassword", "123123");
        homePage = registerPage.clickRegisterButton();

    }
}
