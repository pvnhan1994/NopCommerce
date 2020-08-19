package adminPageObjects;

import adminPageUIs.ProductsPageUIs;
import commons.AbstractPage;
import commons.AbstractPageUIs;
import org.openqa.selenium.WebDriver;

public class ProductsPageObject extends AbstractPage {
    WebDriver driver;

    public ProductsPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }


    public int countMappingKeywordInTableResult(String keyword) {
        waitForElementVisible(driver, ProductsPageUIs.MAPPING_KEYWORD_IN_TABLE, keyword);
        return listSizeLocatorInElements(driver, ProductsPageUIs.MAPPING_KEYWORD_IN_TABLE, keyword);
    }

    public void uncheckToTheSearchSubCategoriesCheckBox() {
        waitForElementVisible(driver, ProductsPageUIs.CHECKBOX_SEARCH_SUBCATEGORIES);
        uncheckToTheCheckbox(driver, ProductsPageUIs.CHECKBOX_SEARCH_SUBCATEGORIES);
    }

    public boolean isMessageNoDataInTable(String msg) {
        waitForElementVisible(driver, ProductsPageUIs.MAPPING_KEYWORD_IN_TABLE, msg);
        return isControlDisplayed(driver, ProductsPageUIs.MAPPING_KEYWORD_IN_TABLE, msg);
    }

    public void checkToTheSearchSubCategoriesCheckBox() {
        waitForElementVisible(driver,ProductsPageUIs.CHECKBOX_SEARCH_SUBCATEGORIES);
        checkToTheCheckbox(driver, ProductsPageUIs.CHECKBOX_SEARCH_SUBCATEGORIES);
    }

    public String getNameProductInDisplayed(String productName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID,productName);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID,"value",productName);
    }

    public void clickIntoIconExpandCollapseComponent() {

        if(isControlUndisplayed(driver,ProductsPageUIs.UP_COMPONENT) == false){
            clickToElement(driver,ProductsPageUIs.DOWN_COMPONENT);
        }


    }
}
