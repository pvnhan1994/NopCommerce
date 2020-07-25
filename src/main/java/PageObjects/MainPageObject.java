package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.MainPageUI;

public class MainPageObject extends AbstractPage {
    WebDriver driver;

    public MainPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public RegisterPageObject clickRegisterItem() {
        waitForElementVisible(driver, MainPageUI.REGISTER_ITEM);
        clickToElement(driver, MainPageUI.REGISTER_ITEM);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject clickLoginItem() {
        waitForElementVisible(driver, MainPageUI.LOGIN_ITEM);
        clickToElement(driver, MainPageUI.LOGIN_ITEM);
        return PageGeneratorManager.getLoginPage(driver);

    }
}
