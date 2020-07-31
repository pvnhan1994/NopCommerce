package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.MainPageUI;
import pageUIs.MyAccountPageUIs;
import sun.applet.Main;

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
    public void hoverIntoMenuTopProduct(String nameCategory){
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT,nameCategory);
        hoverMouseToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT,nameCategory);
    }
    public void clickIntoMenuTopProduct(String nameCategory){
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        clickToElement(driver,MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }
    public boolean isItemProductDisplayedCorrect(WebDriver driver,int numberItemExpected){
        waitForElementVisible(driver, MainPageUI.ITEM_PRODUCT);
        int numberItemActual = listSizeLocatorInElements(driver, MainPageUI.ITEM_PRODUCT);
        System.out.println("number item actual: "+ numberItemActual);
        System.out.println("number item expected: "+ numberItemExpected);
        if (numberItemActual <= numberItemExpected){
            return true;
        }else
            return false;
    }
     public void clickIntoItemNavigatePaging(String valueNavigate){
        waitForElementVisible(driver, MainPageUI.PAGING_NAVIGATE,valueNavigate);
        clickToElement(driver, MainPageUI.PAGING_NAVIGATE, valueNavigate);
    }
}
