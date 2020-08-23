package adminPageObjects;

import adminPageUIs.CustomersPageUIs;
import adminPageUIs.ProductsPageUIs;
import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CustomersPageObject extends AbstractPage {
    WebDriver driver;

    public CustomersPageObject(WebDriver mapping) {
        driver = mapping;
    }

    public void clickIntoAddNewButton() {
        waitForElementVisible(driver, CustomersPageUIs.ADD_NEW_BUTTON);
        clickToElement(driver, CustomersPageUIs.ADD_NEW_BUTTON);
    }

    public void selectRoleCustomer(String value) throws Exception {
        waitForElementVisible(driver, CustomersPageUIs.ROLE_DROPDOWN);
        selectItemInCustomDropdownClickByWebdriver(driver, CustomersPageUIs.ROLE_DROPDOWN, CustomersPageUIs.LISTITEM_IN_ROLE_DROPDOWN, value);
//        selectMultiItemInDropdown(driver,CustomersPageUIs.ROLE_DROPDOWN,CustomersPageUIs.LISTITEM_IN_ROLE_DROPDOWN, CustomersPageUIs.ITEM_SELECTED_DROPDOWN, value);
    }

    public void clearRole() {
        waitForElementPresence(driver, CustomersPageUIs.CLEAR_ITEM_IN_ROLE_DROPDOWN);
        clickToElementByJS(driver, CustomersPageUIs.CLEAR_ITEM_IN_ROLE_DROPDOWN);
    }

    public void clickIntoSaveContinuteButton() {
        waitForElementVisible(driver, CustomersPageUIs.SAVE_CONTINUTE_BUTTON);
        clickToElement(driver, CustomersPageUIs.SAVE_CONTINUTE_BUTTON);
    }

    public String getToastMsgAddCustomerSuccess() {
        waitForElementVisible(driver, CustomersPageUIs.TOAST_MSG_ADD_SUCCESS);
        String s = getTextElement(driver, CustomersPageUIs.TOAST_MSG_ADD_SUCCESS).replaceAll("×", "").trim();
        return s;
    }

    public boolean isGenderSelected(String idRadio) {
        waitForElementVisible(driver, CustomersPageUIs.GENDER_RADIO, idRadio);
        return isControlSelected(driver, CustomersPageUIs.GENDER_RADIO, idRadio);
    }

    public String getTextRoleInRoleCustomerDropDown(String nameRole) {
        waitForElementVisible(driver, CustomersPageUIs.ROLE_SELECTED, nameRole);
        return getTextElement(driver, CustomersPageUIs.ROLE_SELECTED, nameRole);
    }

    public int countMappingKeywordInTableResult(String keyword) {
        waitForElementVisible(driver, CustomersPageUIs.MAPPING_KEYWORD_IN_TABLE, keyword);
        return listSizeLocatorInElements(driver, CustomersPageUIs.MAPPING_KEYWORD_IN_TABLE, keyword);
    }
}