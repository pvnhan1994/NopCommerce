package PageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoUIs;


public class CustomerInfoPageObject extends AbstractPage {
    WebDriver driver;

    public CustomerInfoPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }


    public void clickToSaveButton() {
        waitForElementVisible(driver, CustomerInfoUIs.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoUIs.SAVE_BUTTON);
    }

    public String getDynamicAttribueTextboxValue(WebDriver driver, String textboxID, String attributeName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, textboxID);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, attributeName, textboxID);
    }

    public String getTextDOBDropdown(WebDriver driver, String nameDropdown) {
        waitForElementVisible(driver, CustomerInfoUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
        return getFirstSelectedDropdown(driver, CustomerInfoUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
    }

    public boolean isGenderSelected(WebDriver driver, String nameID) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
        return isControlSelected(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
    }

}
