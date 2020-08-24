package customerPageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import org.openqa.selenium.WebDriver;
import customerPageUIs.CustomerInfoUIs;


public class CustomerInfoPageObject extends AbstractPage {
    WebDriver driver;

    public CustomerInfoPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }


    public void clickToSaveButton() {
        waitForElementVisible(driver, CustomerInfoUIs.SAVE_BUTTON);
        clickToElement(driver, CustomerInfoUIs.SAVE_BUTTON);
    }



    public String getTextDOBDropdown(WebDriver driver, String nameDropdown) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
        return getFirstSelectedDropdown(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
    }

    public boolean isGenderSelected(WebDriver driver, String nameID) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
        return isControlSelected(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
    }

}
