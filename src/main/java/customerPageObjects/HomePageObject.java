package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.HomePageUIs;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isMyAccountItemDisplayed() {
        waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_ITEM);
        return isControlDisplayed(driver, HomePageUIs.MY_ACCOUNT_ITEM);
    }

}
