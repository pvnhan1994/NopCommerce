package wishList_compare_recentView;

import PageObjects.*;
import commons.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageUIs.MyAccountPageUIs;
import pageUIs.WishListPageUIs;

public class id001_withListProduct extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    WishListPageObject wishListPage;

    String nameProduct = "Lenovo IdeaCentre 600 All-in-One PC";

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String nameBrowser) {
        driver = openMultiBrowser(nameBrowser);
        mainPage = PageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        myAccountPage = homePage.clickToMyAccountItem(driver);
        myAccountPage.hoverIntoMenuTopProduct(driver, "Computers");
        myAccountPage.clickIntoMenuTopProduct(driver, "Desktops");

        log.info("Step 1: Click open Product Detail");
        myAccountPage.openProductDetails(nameProduct);
        String skuProduct = myAccountPage.getTextSkuCode();
        String nameProduct = myAccountPage.getTextNameProduct();
        log.info("Step 2: Click wishlist button");

        myAccountPage.clickIntoDynamicButtonWithClass(driver, "button-2 add-to-wishlist-button");


        log.info("Step 3: Verify toast msg");
        verifyEquals("The product has been added to your wishlist", myAccountPage.getTextToastMessageDisplayed(driver));

        log.info("Step 4: Open wishList page");
        wishListPage = (WishListPageObject) myAccountPage.openMultiPageInFooter(driver, "Wishlist");

        log.info("Step 5: Verify add product success");
        verifyEquals(skuProduct, wishListPage.getTextSkuCodeSuccess(nameProduct));
        verifyEquals(nameProduct, wishListPage.getTextNameProductSuccess(nameProduct));

    }

    @Test
    public void TC01_AddToWishlist() {

        log.info("Step 6: Click share link");
        wishListPage.clickIntoShareLink();

        log.info("Step 7: Verify name wishlist");
        verifyEquals("Wishlist of " + Constants.FIRST_NAME + " " + Constants.LAST_NAME, wishListPage.getTextNameWishList());
    }


    public void TC02_AddProductToCartFromWishListPage() {

        log.info("Step 6: Checkbox Add to Cart");
        wishListPage.selectCheckBox(nameProduct, "add-to-cart");

        log.info("Step 7: Click button Add to Cart");
        wishListPage.clickIntoDynamicButtonWithClass(driver, "button-2 wishlist-add-to-cart-button");

        log.info("Step 8: Verify number wishlist and Cart");
        verifyEquals("(0)", wishListPage.getNumberProduct("wishlist-qty"));
        verifyEquals("(1)", wishListPage.getNumberProduct("cart-qty"));

    }


    public void TC03_RemoveProductInWishListPage() {
        log.info("Step 6: Checkbox Remove");
        wishListPage.selectCheckBox(nameProduct, "remove-from-cart");

        log.info("Step 7: Click button Update Wishlist");
        wishListPage.clickIntoDynamicButtonWithClass(driver, "button-2 update-wishlist-button");

        log.info("Step 8: Verify message empty is displayed");
        verifyTrue(wishListPage.isMessageEmptyDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeBrowserAndDriver(driver);
    }


}
