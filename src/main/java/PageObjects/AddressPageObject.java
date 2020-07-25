package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUIs;
import pageUIs.MyAccountPageUIs;

public class AddressPageObject extends AbstractPage {
    WebDriver driver;
    public AddressPageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }
    public String getDynamicTextWithTableLi(String inforName){
        waitForElementVisible(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
        return getTextElement(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
    }
    public ChangePasswordPageObject clickDynamicMenuBar( String nameMenu) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_BAR, nameMenu );
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_BAR, nameMenu);
        return PageGeneratorManager.getChangePasswordPage(driver);
    }

}
