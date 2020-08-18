package customerPageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import customerPageUIs.CheckOutPagetUIs;
import customerPageUIs.ShoppingCartPageUIs;

public class ShoppingCartPageObject extends AbstractPage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public ProductDetailPageObject clickEditItem() {
        waitForElementVisible(driver, ShoppingCartPageUIs.EDIT_ITEM);
        clickToElementByJS(driver, ShoppingCartPageUIs.EDIT_ITEM);
        return PageGeneratorManager.getProductDetail(driver);
    }

    public void clickRemoveProductCheckBox() {
        waitForElementVisible(driver, ShoppingCartPageUIs.REMOVE_CHECKBOX);
        clickToElementByJS(driver, ShoppingCartPageUIs.REMOVE_CHECKBOX);
    }

    public boolean isProductUndisplayed(String nameProduct) {
        waitForElementInvisible(driver, ShoppingCartPageUIs.NAME_PRODUCT, nameProduct);
        return isControlUndisplayed(driver, ShoppingCartPageUIs.NAME_PRODUCT, nameProduct);
    }

    public String getExpectedValueSubTotal() {
        waitForElementVisible(driver, ShoppingCartPageUIs.SUB_TOTAL);
        return getTextElement(driver, ShoppingCartPageUIs.SUB_TOTAL);
    }

    public String getActualValueSubTotal(String pricePerUnit, String qualityProduct) {
        int totalSubPrice = convertPriceIntoInt(pricePerUnit) * convertPriceIntoInt(qualityProduct);
        String s = "$" + String.valueOf(totalSubPrice) + ".00";
        return s;
    }

    public int convertPriceIntoInt(String pricePerUnit) {
        String s = pricePerUnit.replaceAll("(\\$)|(\\.00)", "");
        int i = Integer.parseInt(s);
        return i;
    }

    public void inputNumberForUpdateQtyProduct(String qty) {
        waitForElementVisible(driver, ShoppingCartPageUIs.QTY_TEXTBOX);
        sendkeyElements(driver, ShoppingCartPageUIs.QTY_TEXTBOX,qty);

    }

    public CheckOutPageObject clickCheckOutButton() {
        waitForElementVisible(driver, CheckOutPagetUIs.CHECK_OUT_BUTTON);
        clickToElementByJS(driver, CheckOutPagetUIs.CHECK_OUT_BUTTON);
        return PageGeneratorManager.getCheckOutPage(driver);
    }
}
