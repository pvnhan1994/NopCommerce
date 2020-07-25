package PageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends AbstractPage {
    WebDriver driver;
    public ChangePasswordPageObject(WebDriver mappingDriver){
        driver=mappingDriver;
    }

    public MainPageObject clickIntoLogOutButton() {
        waitForElementVisible(driver, AbstractPageUIs.LOGOUT_ITEM);
        clickToElement(driver,AbstractPageUIs.LOGOUT_ITEM);
        return PageGeneratorManager.getMainPage(driver);
    }
}
