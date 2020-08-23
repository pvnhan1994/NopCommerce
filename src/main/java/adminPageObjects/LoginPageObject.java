package adminPageObjects;

import adminPageUIs.LoginPageUIs;
import commons.AbstractPage;
import commons.AdminPageGeneratorManager;
import customerPageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public DashboardPageObject clickIntoLoginButton() {
        waitForElementVisible(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
        return AdminPageGeneratorManager.getDashboardPage(driver);
    }
}
