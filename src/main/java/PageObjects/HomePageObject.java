package PageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUIs;
import pageUIs.MyAccountPageUIs;

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

    public SearchPageObject clickIntoSearchItemFooter(String searchName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, searchName);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, searchName);
        return PageGeneratorManager.getSearchPage(driver);
    }
    public MainPageObject clickLogoNopCommerce() {
        waitForElementVisible(driver, MyAccountPageUIs.LOGO_NOP);
        clickToElement(driver, MyAccountPageUIs.LOGO_NOP);
        return PageGeneratorManager.getMainPage(driver);
    }
}
