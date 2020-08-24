package adminPageObjects;

import adminPageUIs.CustomersPageUIs;
import adminPageUIs.ProductsPageUIs;
import commons.AbstractPage;
import customerPageUIs.AddressPageUIs;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CustomersPageObject extends AbstractPage {
    WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

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

    public String getToastMsgSuccess() {
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

    public void clickIntoEditButton(String emailEdit) {
        waitForElementVisible(driver, CustomersPageUIs.EDIT_BUTTON, emailEdit);
        clickToElement(driver, CustomersPageUIs.EDIT_BUTTON, emailEdit);
    }

    public void clickIntoSaveButton() {
        waitForElementVisible(driver, CustomersPageUIs.SAVE_BUTTON);
        clickToElement(driver, CustomersPageUIs.SAVE_BUTTON);
    }

    public void selectStateProvince(String value) {
        waitForElementInvisible(driver, CustomersPageUIs.LOADING_STATE_PROVINCE);
        waitForElementVisible(driver, CustomersPageUIs.STATE_PROVINCE);
        selectItemInDropDown(driver, CustomersPageUIs.STATE_PROVINCE, value);
    }

    public void clickIntoAddressContainer() {
        waitForElementVisible(driver, CustomersPageUIs.ADDRESS_CONTAINER);
        clickToElementByJS(driver, CustomersPageUIs.ADDRESS_CONTAINER);
    }

    public void clickIntoAddNewAddress() {
        waitForElementVisible(driver, CustomersPageUIs.ADD_NEW_ADDRESS_BUTTON);
        clickToElementByJS(driver, CustomersPageUIs.ADD_NEW_ADDRESS_BUTTON);
    }

    public void clickIntoSaveAddressButton() {
        waitForElementVisible(driver, CustomersPageUIs.SAVE_ADDRESS_BUTTON);
        scrollToElement(driver, CustomersPageUIs.SAVE_ADDRESS_BUTTON);
        clickToElement(driver, CustomersPageUIs.SAVE_ADDRESS_BUTTON);
    }

    public void clickIntoItemBackToCustomerDetail() {
        waitForElementVisible(driver, CustomersPageUIs.BACK_TO_CUSTOMER_DETAIL_BUTTON);
        clickToElement(driver, CustomersPageUIs.BACK_TO_CUSTOMER_DETAIL_BUTTON);
    }

    public void clickIntoEditAddressButton(String emailNeedEdit) {
        waitForElementVisible(driver, CustomersPageUIs.EDIT_ADDRESS_BUTTON, emailNeedEdit);
        clickToElementByJS(driver, CustomersPageUIs.EDIT_ADDRESS_BUTTON, emailNeedEdit);
    }

    public String getDynamicTextInTableGridByIndex(WebDriver driver, String index) {
        waitForElementVisible(driver, CustomersPageUIs.VALUE_TABLE_GRID, index);
        return getTextElement(driver, CustomersPageUIs.VALUE_TABLE_GRID, index);
    }

    public void clickIntoIconExpandCollapseComponent() {

        if (isControlUndisplayed(driver, ProductsPageUIs.UP_COMPONENT) == false) {
            clickToElement(driver, ProductsPageUIs.DOWN_COMPONENT);
        }

    }
}