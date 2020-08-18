package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.CompareProductListUIs;

public class CompareProductListPageObject extends AbstractPage {
    WebDriver driver;

    public CompareProductListPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public String getPriceProduct(String indexProduct) {
        waitForElementVisible(driver, CompareProductListUIs.PRICE_PRODUCT, indexProduct);
        return getTextElement(driver, CompareProductListUIs.PRICE_PRODUCT, indexProduct);
    }
    public String getNameProduct(String indexProduct){
        waitForElementVisible(driver, CompareProductListUIs.NAME_PRODUCT, indexProduct);
        return getTextElement(driver, CompareProductListUIs.NAME_PRODUCT, indexProduct);
    }
    public boolean isRemoveIconDisplayed(String indexProduct){
        waitForElementVisible(driver, CompareProductListUIs.REMOVE_PRODUCT, indexProduct);
        return isControlDisplayed(driver, CompareProductListUIs.REMOVE_PRODUCT, indexProduct);
    }

    public void clickIntoClearListButton() {
        waitForElementVisible(driver, CompareProductListUIs.CLEAR_LIST_BUTTON);
        clickToElement(driver, CompareProductListUIs.CLEAR_LIST_BUTTON);
    }

    public boolean isMessageClearListSuccessDisplayed() {
        waitForElementVisible(driver, CompareProductListUIs.MESSAGE_CLEAR_LIST);
        return isControlDisplayed(driver, CompareProductListUIs.MESSAGE_CLEAR_LIST);
    }
}
