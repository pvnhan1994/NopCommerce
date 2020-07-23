package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;

    public RegisterPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void clickRegisterButton() {
        waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
        // clickToElement(driver, RegisterPageUI.REGISTER_BTN);
        clickToElementByJS(driver, RegisterPageUI.REGISTER_BTN);
    }

    public boolean isMessageSuccessDisplayed(String value) {
        waitForElementVisible(driver, RegisterPageUI.MESSAGE_SUCCESS);
        return isControlDisplayed(driver, RegisterPageUI.MESSAGE_SUCCESS,value);
    }
}
