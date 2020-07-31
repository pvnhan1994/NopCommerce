package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.WishListPageUIs;

public class WishListPageObject extends AbstractPage {
    WebDriver driver;

    public WishListPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void clickIntoShareLink() {
        waitForElementVisible(driver, WishListPageUIs.SHARE_LINK);
        clickToElement(driver, WishListPageUIs.SHARE_LINK);
    }

    public String getNumberProduct(String item) {
        waitForElementVisible(driver, WishListPageUIs.NUMER_PRODUCT, item);
        return getTextElement(driver, WishListPageUIs.NUMER_PRODUCT, item);
    }

    public void selectCheckBox(String nameProduct, String optionCheckboxByClass) {
        waitForElementVisible(driver, WishListPageUIs.CHECKBOX, nameProduct, optionCheckboxByClass);
        clickToElement(driver, WishListPageUIs.CHECKBOX, nameProduct, optionCheckboxByClass);
    }


}
