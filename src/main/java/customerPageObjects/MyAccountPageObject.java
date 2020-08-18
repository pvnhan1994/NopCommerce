package customerPageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import customerPageUIs.MyAccountPageUIs;

public class MyAccountPageObject extends AbstractPage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public void hoverIntoMenuTopProduct(String nameCategory) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        hoverMouseToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public void clickIntoMenuTopProduct(String nameCategory) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public ProductDetailPageObject openProductDetails(String nameProduct) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS, nameProduct);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS, nameProduct);
        return PageGeneratorManager.getProductDetail(driver);

    }

    public void clickAddYourReviewItem() {
        waitForElementVisible(driver, MyAccountPageUIs.ADD_YOUR_REVIEW_ITEM);
        clickToElement(driver, MyAccountPageUIs.ADD_YOUR_REVIEW_ITEM);
    }



    public String getPriceProduct(String nameProduct) {
        waitForElementVisible(driver, MyAccountPageUIs.PRICE_PRODUCT, nameProduct);
        return getTextElement(driver, MyAccountPageUIs.PRICE_PRODUCT, nameProduct);
    }


    public void clickIntoCompareProductButton(String nameProduct, String indexButton) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_OPTION_BUTTON_PRODUCT_DETAIL, nameProduct, indexButton);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_OPTION_BUTTON_PRODUCT_DETAIL, nameProduct, indexButton);
    }

}
