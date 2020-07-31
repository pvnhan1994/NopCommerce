package PageObjects;

import commons.AbstractPage;
import commons.AbstractPageUIs;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.MyAccountPageUIs;

public class MyAccountPageObject extends AbstractPage {
    WebDriver driver;

    public MyAccountPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public CustomerInfoPageObject clickCustomerInfoMenuBar() {
        waitForElementVisible(driver, MyAccountPageUIs.CUSTOMER_INFO_MENU_BAR);
        clickToElement(driver, MyAccountPageUIs.CUSTOMER_INFO_MENU_BAR);
        return PageGeneratorManager.getCustomerInfoPage(driver);
    }

    public MyProductReviewsPageObject clickMyProductReviewsMenuBar() {
        waitForElementVisible(driver, MyAccountPageUIs.MY_PRODUCT_REVIEWS_MENU_BAR);
        clickToElement(driver, MyAccountPageUIs.MY_PRODUCT_REVIEWS_MENU_BAR);
        return PageGeneratorManager.getMyProductReviewsPage(driver);
    }

    public void hoverIntoMenuTopProduct(String nameCategory) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        hoverMouseToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public void clickIntoMenuTopProduct(String nameCategory) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public void openProductDetails(String nameProduct) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS, nameProduct);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS, nameProduct);
    }

    public void clickAddYourReviewItem() {
        waitForElementVisible(driver, MyAccountPageUIs.ADD_YOUR_REVIEW_ITEM);
        clickToElement(driver, MyAccountPageUIs.ADD_YOUR_REVIEW_ITEM);
    }

    public HomePageObject clickLogoNopCommerce() {
        waitForElementVisible(driver, MyAccountPageUIs.LOGO_NOP);
        clickToElement(driver, MyAccountPageUIs.LOGO_NOP);
        return PageGeneratorManager.getHomePage(driver);
    }

    public WishListPageObject clickIntoWishListItemFooter(String wishListName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, wishListName);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, wishListName);
        return PageGeneratorManager.getWishListPage(driver);
    }
    public CompareProductListPageObject clickIntoCompareProdcutListItemFooter(String compareProductListName){
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE,  compareProductListName);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, compareProductListName);
        return PageGeneratorManager.getCompareProductListPage(driver);
    }


    public void clickIntoCompareProductButton(String nameProduct, String indexButton) {
        waitForElementVisible(driver, MyAccountPageUIs.DYNAMIC_OPTION_BUTTON_PRODUCT_DETAIL, nameProduct, indexButton);
        clickToElement(driver, MyAccountPageUIs.DYNAMIC_OPTION_BUTTON_PRODUCT_DETAIL, nameProduct, indexButton);
    }

}
