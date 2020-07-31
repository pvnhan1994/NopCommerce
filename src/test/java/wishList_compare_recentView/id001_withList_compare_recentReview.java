package wishList_compare_recentView;

import PageObjects.*;
import commons.AbstractPageUIs;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageUIs.MyAccountPageUIs;
import pageUIs.WishListPageUIs;

public class id001_withList_compare_recentReview extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    WishListPageObject wishListPage;

    String password = "123123";
    String email = "chandoid1111s@gmail.com";
    String firstName = "Nhan";
    String lastName = "Phan";
    String nameProduct = "Apple MacBook Pro 13-inch";
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String nameBrowser) {
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
        myAccountPage.clickIntoMenuTopProduct("Notebooks");

    }

    @Test
    public void TC01_AddToWishlist() {
        log.info("Step 1: Click open Product Detail");
        myAccountPage.openProductDetails(nameProduct);
        String skuProduct = myAccountPage.getTextElement(driver, MyAccountPageUIs.SKU_DETAIL_PRODUCT);
        String nameProduct = myAccountPage.getTextElement(driver, MyAccountPageUIs.NAME_DETAIL_PRODUCT);
        log.info("Step 2: Click wishlist button");

        myAccountPage.clickIntoDynamicButton(driver, "button-2 add-to-wishlist-button");


        log.info("Step 3: Verify toast msg");
        verifyEquals("The product has been added to your wishlist", myAccountPage.getTextElement(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG));

        log.info("Step 4: Open wishList page");
        wishListPage = myAccountPage.clickIntoWishListItemFooter("Wishlist");

        log.info("Step 5: Verify add product success");
        verifyEquals(skuProduct, wishListPage.getTextElement(driver, WishListPageUIs.SKU_ID, nameProduct));
        verifyEquals(nameProduct, wishListPage.getTextElement(driver, WishListPageUIs.NAME, nameProduct));


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
