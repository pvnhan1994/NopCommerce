package customerPageObjects;

import commons.AbstractPage;
import commons.CustomerPageGeneratorManager;
import org.openqa.selenium.WebDriver;
import customerPageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

    WebDriver driver;

    public LoginPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }


    public HomePageObject clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElementByJS(driver, LoginPageUI.LOGIN_BUTTON);
        return CustomerPageGeneratorManager.getHomePage(driver);
    }

    public boolean isErrorMessageDisplayed(String errorMsg) {
        waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE);
        return isControlDisplayed(driver, LoginPageUI.ERROR_MESSAGE, errorMsg);
    }
}
