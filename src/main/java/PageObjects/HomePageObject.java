package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUIs;

public class HomePageObject extends AbstractPage {
    WebDriver driver;
    public HomePageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }

    public boolean isMyAccountItemDisplayed() {
        waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_ITEM);
        return isControlDisplayed(driver, HomePageUIs.MY_ACCOUNT_ITEM);
    }

    public MyAccountPageObject clickToMyAccountItem() {
        waitForElementVisible(driver, HomePageUIs.MY_ACCOUNT_ITEM);
        clickToElementByJS(driver, HomePageUIs.MY_ACCOUNT_ITEM);
        return PageGeneratorManager.getMyAccountPage(driver);
    }
}
