package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPageUIs;

public class MyAccountPageObject extends AbstractPage {
    WebDriver driver;
    public MyAccountPageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }

    public CustomerInfoPageObject clickDynamicMenuBar(String nameMenu) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_BAR, nameMenu );
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_BAR, nameMenu);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }
}
