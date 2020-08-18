package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.ProductDetailPageUIs;

public class ProductDetailPageObject extends AbstractPage {
    WebDriver driver;

    public ProductDetailPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;

    }

    public String getTextSkuCode() {
        waitForElementVisible(driver, ProductDetailPageUIs.SKU_DETAIL_PRODUCT);
        return getTextElement(driver, ProductDetailPageUIs.SKU_DETAIL_PRODUCT);
    }



    public void selectDynamicDropDownConfig(String nameConfig, String value) {
        waitForElementVisible(driver, ProductDetailPageUIs.DROPDOWN_LIST_CONFIG, nameConfig);
        selectItemInDropDown(driver, ProductDetailPageUIs.DROPDOWN_LIST_CONFIG, value, nameConfig);
    }

    public void selectDynamicRadioButtonConfig(String nameConfig, String valueRadioButton) {
        waitForElementVisible(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueRadioButton);
        clickToElement(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueRadioButton);
    }

    public void selectDynamicCheckboxConfig(String nameConfig, String valueCheckbox) {
        waitForElementVisible(driver, ProductDetailPageUIs.CHECKBOX, nameConfig, valueCheckbox);
        checkToTheCheckbox(driver, ProductDetailPageUIs.CHECKBOX, nameConfig, valueCheckbox);
    }

    public void selectDynamicUnCheckboxConfig(String nameConfig, String valueUnCheckbox) {
        waitForElementVisible(driver, ProductDetailPageUIs.CHECKBOX, nameConfig, valueUnCheckbox);
        uncheckToTheCheckbox(driver, ProductDetailPageUIs.CHECKBOX, nameConfig, valueUnCheckbox);
    }

    public String getDynamicValueDropdownConfig(String nameConfig, String value) {
        waitForElementVisible(driver, ProductDetailPageUIs.DROPDOWN_LIST_CONFIG, nameConfig, value);
        return getFirstSelectedDropdown(driver, ProductDetailPageUIs.DROPDOWN_LIST_CONFIG, nameConfig, value);
    }


    public String getDynamicValueRadioButtonConfig(String nameConfig, String valueRadioButton) {
        waitForElementVisible(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueRadioButton);
        return getTextElement(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueRadioButton);
    }

    public String getDynamicValueCheckboxConfig(String nameConfig, String valueCheckbox) {
        waitForElementVisible(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueCheckbox);
        return getTextElement(driver, ProductDetailPageUIs.RADIO_BUTTON_CHECKBOX_CONFIG, nameConfig, valueCheckbox);
    }

    public String getTotalPrice() {
        waitForElementVisible(driver, ProductDetailPageUIs.TOTAL_PRICE);
        return getTextElement(driver, ProductDetailPageUIs.TOTAL_PRICE);
    }
    public String getQuantityProduct() {
        waitForElementVisible(driver, ProductDetailPageUIs.QUANTITY_PRODUCT);
        return getAttributeValue(driver, ProductDetailPageUIs.QUANTITY_PRODUCT, "value");
    }

    public String getInforOverviewProduct(String className){
        waitForElementVisible(driver, ProductDetailPageUIs.DYNAMIC_OVERVIEW_DETAIL_PRODUCT,className);
        return getTextElement(driver, ProductDetailPageUIs.DYNAMIC_OVERVIEW_DETAIL_PRODUCT,className);
    }


}
