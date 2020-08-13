package order;

import PageObjects.*;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class id002_updateCheckOutProduct extends AbstractTest {
    WebDriver driver;
    MyAccountPageObject myAccountPage;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    ProductDetailPageObject productDetailPage;
    ShoppingCartPageObject shoppingCartPage;
    CheckOutPageObject checkOutPage;
    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser){
        driver = openMultiBrowser(browser);
        mainPage = PageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        myAccountPage = (MyAccountPageObject) homePage.openMultiPageInItemHeader(driver, "ico-account");
        myAccountPage.hoverIntoMenuTopProduct(driver, "Computers");
        myAccountPage.clickIntoMenuTopProduct(driver, "Desktops");
        log.info("Step 1: Open Prodcut Detail");
        productDetailPage = myAccountPage.openProductDetails("Lenovo IdeaCentre 600 All-in-One PC");

        log.info("Step 2: Click button Add to cart");
        productDetailPage.clickIntoDynamicButtonWithClass(driver, "button-1 add-to-cart-button");
    }
    @Test
    public void TC04_UpdateShoppingCart(){
        String qualityUpdate = "5";

        log.info("Step 3: Get price/unit");
        String totalPrice = productDetailPage.getInforOverviewProduct("prices");

        log.info("Step 4: Verify toast msg displayed");
        verifyEquals("The product has been added to your shopping cart", productDetailPage.getTextToastMessageDisplayed(driver));
        log.info("Step 4.1: Close toast msg");
        productDetailPage.clickCloseToastMsg(driver);

        log.info("Step 5: Open Shopping Cart");
        shoppingCartPage = (ShoppingCartPageObject) productDetailPage.openMultiPageInItemHeader(driver, "ico-cart");

        log.info("Step 6: Input value updateQuality");
        shoppingCartPage.inputNumberForUpdateQtyProduct(qualityUpdate);

        log.info("Step 7: Click Update button");
        shoppingCartPage.clickIntoDynamicButtonWithClass(driver,"button-2 update-cart-button");

        log.info("Step 8: Verify sub-total displays correct");
        verifyEquals(shoppingCartPage.getActualValueSubTotal(totalPrice,qualityUpdate),shoppingCartPage.getExpectedValueSubTotal());

    }
    @Test
    public void TC05_CheckOut_Order(){
        log.info("Step : Click Checkbox agree");
        checkOutPage = shoppingCartPage.clickCheckOutButton();
        log.info("Step : Click Checkout button");

        log.info("Step : Checkout screen is displays");
        log.info("Step : Header screen is displays");
        log.info("Step : Page Billing address displays");
        log.info("Step : Input infor");

        checkOutPage.selectDynamicCheckbox(driver,"ShipToSameAddress");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_FirstName","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_LastName","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_Email","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_Company","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_City","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_Address1","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_Address2","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_ZipPostalCode","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_PhoneNumber","");
        checkOutPage.inputIntoDynamicTextbox(driver,"BillingNewAddress_FaxNumber","");
        checkOutPage.selectDynamicDropDown(driver,"ShipToSameAddress","");




    }
    @AfterMethod
    public void afterMethos(){
        closeBrowserAndDriver(driver);
    }
}
