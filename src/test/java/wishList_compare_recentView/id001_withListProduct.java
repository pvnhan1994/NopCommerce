package wishList_compare_recentView;

import PageObjects.*;
import commons.AbstractPageUIs;
import commons.AbstractTest;
import commons.PageGeneratorManager;
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

    String password = "123123";
   // String email = "aloxinh"+randomDataTest()+"@gmail.com";
    String firstName = "Nhan";
    String lastName = "Phan";
    String nameProduct = "Lenovo IdeaCentre 600 All-in-One PC";
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String nameBrowser) {
        String email = "aloxinh"+randomDataTest()+"@gmail.com";
        driver = openMultiBrowser(nameBrowser);
        mainPage = PageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.inputIntoDynamicTextboxByJS(driver, "FirstName", firstName);
        registerPage.inputIntoDynamicTextboxByJS(driver, "LastName", lastName);
        registerPage.inputIntoDynamicTextboxByJS(driver, "Email", email);
        registerPage.inputIntoDynamicTextboxByJS(driver, "Password", password);
        registerPage.inputIntoDynamicTextboxByJS(driver, "ConfirmPassword", password);
        homePage = registerPage.clickRegisterButton();
        myAccountPage = homePage.clickToMyAccountItem();
        myAccountPage.hoverIntoMenuTopProduct("Computers");
        myAccountPage.clickIntoMenuTopProduct("Desktops");

        log.info("Step 1: Click open Product Detail");
        myAccountPage.openProductDetails(nameProduct);
        String skuProduct = myAccountPage.getTextElement(driver, MyAccountPageUIs.SKU_DETAIL_PRODUCT);
        String nameProduct = myAccountPage.getTextElement(driver, MyAccountPageUIs.NAME_DETAIL_PRODUCT);
        log.info("Step 2: Click wishlist button");

        myAccountPage.clickIntoDynamicButtonWithClass(driver, "button-2 add-to-wishlist-button");


        log.info("Step 3: Verify toast msg");
        verifyEquals("The product has been added to your wishlist", myAccountPage.getTextElement(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG));

        log.info("Step 4: Open wishList page");
        wishListPage = myAccountPage.clickIntoWishListItemFooter("Wishlist");

        log.info("Step 5: Verify add product success");
        verifyEquals(skuProduct, wishListPage.getTextElement(driver, WishListPageUIs.SKU_ID, nameProduct));
        verifyEquals(nameProduct, wishListPage.getTextElement(driver, WishListPageUIs.NAME_PRODUCT, nameProduct));
    }


    public void TC01_AddToWishlist() {

        log.info("Step 6: Click share link");
        wishListPage.clickIntoShareLink();

        log.info("Step 7: Verify name wishlist");
        verifyEquals("Wishlist of "+firstName+" "+lastName, wishListPage.getTextElement(driver,WishListPageUIs.NAME_WISHLIST));
    }


    public void TC02_AddProductToCartFromWishListPage(){

        log.info("Step 6: Checkbox Add to Cart");
        wishListPage.selectCheckBox(nameProduct,"add-to-cart");

        log.info("Step 7: Click button Add to Cart");
        wishListPage.clickIntoDynamicButtonWithClass(driver, "button-2 wishlist-add-to-cart-button");

        log.info("Step 8: Verify number wishlist and Cart");
        verifyEquals("(0)",wishListPage.getNumberProduct("wishlist-qty"));
        verifyEquals("(1)",wishListPage.getNumberProduct("cart-qty"));

    }
    @Test
    public void TC03_RemoveProductInWishListPage(){
        log.info("Step 6: Checkbox Remove");
        wishListPage.selectCheckBox(nameProduct,"remove-from-cart");

        log.info("Step 7: Click button Update Wishlist");
        wishListPage.clickIntoDynamicButtonWithClass(driver, "button-2 update-wishlist-button");

        log.info("Step 8: Verify message empty is displayed");
        wishListPage.isControlDisplayed(driver,WishListPageUIs.MESSAGE_EMPTY);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeBrowserAndDriver(driver);
    }


}
