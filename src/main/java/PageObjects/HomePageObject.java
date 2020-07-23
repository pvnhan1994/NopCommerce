package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public RegisterPageObject clickRegisterItem() {
        waitForElementVisible(driver, HomePageUI.REGISTER_BTN);
        clickToElement(driver, HomePageUI.REGISTER_BTN);
        return PageGeneratorManager.getRegisterPage(driver);
    }

}
