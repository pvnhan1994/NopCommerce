package PageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoUIs;
import pageUIs.MyAccountPageUIs;

public class CustomerInfoPageObject extends AbstractPage {
    WebDriver driver;
    public CustomerInfoPageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }


    public void clickToSaveButton() {
        waitForElementVisible(driver, CustomerInfoUIs.SAVE_BUTTON);
        clickToElement(driver,CustomerInfoUIs.SAVE_BUTTON);
    }

    public String getDynamicAttribueTextboxValue(WebDriver driver,String textboxID,String attributeName){
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX, textboxID);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_TEXTBOX,attributeName,textboxID);
    }

    public String getTextDOBDropdown(WebDriver driver, String nameDropdown){
        waitForElementVisible(driver, CustomerInfoUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
        return getFirstSelectedDropdown(driver,CustomerInfoUIs.DYNAMIC_SELECT_DROPDOWN,nameDropdown);
    }

    public boolean isGenderSelected(WebDriver driver, String nameID){
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_BUTTON,nameID);
        return isControlSelected(driver, AbstractPageUIs.DYNAMIC_RADIO_BUTTON,nameID);
    }
    public AddressPageObject clickAddressMenuBar() {
        waitForElementVisible(driver, MyAccountPageUIs.ADDRESS_MENU_BAR);
        clickToElement(driver, MyAccountPageUIs.ADDRESS_MENU_BAR);
        return PageGeneratorManager.getAddressPage(driver);
    }
}
