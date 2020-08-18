package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.WishListPageUIs;

public class WishListPageObject extends AbstractPage {
    WebDriver driver;

    public WishListPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void clickIntoShareLink() {
        waitForElementVisible(driver, WishListPageUIs.SHARE_LINK);
        clickToElement(driver, WishListPageUIs.SHARE_LINK);
    }

    public void selectCheckBox(String nameProduct, String optionCheckboxByClass) {
        waitForElementVisible(driver, WishListPageUIs.CHECKBOX, nameProduct, optionCheckboxByClass);
        clickToElement(driver, WishListPageUIs.CHECKBOX, nameProduct, optionCheckboxByClass);
    }


    public String getTextNameProductSuccess(String nameProduct) {
        waitForElementVisible(driver, WishListPageUIs.NAME_PRODUCT, nameProduct);
        return getTextElement(driver, WishListPageUIs.NAME_PRODUCT, nameProduct);
    }

    public String getTextSkuCodeSuccess(String nameProduct) {
        waitForElementVisible(driver, WishListPageUIs.SKU_ID, nameProduct);
        return getTextElement(driver, WishListPageUIs.SKU_ID, nameProduct);
    }

    public String getTextNameWishList() {
        waitForElementVisible(driver, WishListPageUIs.NAME_WISHLIST);
        return getTextElement(driver, WishListPageUIs.NAME_WISHLIST);
    }


}
