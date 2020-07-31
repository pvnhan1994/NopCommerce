package wishList_compare_recentView;

import PageObjects.*;
import commons.AbstractPageUIs;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageUIs.CompareProductListUIs;
import pageUIs.MyAccountPageUIs;

public class id002_compareProduct extends AbstractTest {

    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    CompareProductListPageObject compareProductListPage;

    String email = "aloxinh" + randomDataTest() + "@gmail.com";
    String password = "123123";
    // String email = "aloxinh"+randomDataTest()+"@gmail.com";
    String firstName = "Nhan";
    String lastName = "Phan";
    String nameProduct1 = "Lenovo IdeaCentre 600 All-in-One PC";
    String nameProduct2 = "Digital Storm VANQUISH 3 Custom Performance PC";
    String indexProduct1 = "3";
    String indexProduct2 = "2";
    @Parameters("browser")
    @Test
    public void TC004_CompareProduct(String nameBrowser) {
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

        String priceProduct1 = myAccountPage.getTextElement(driver, MyAccountPageUIs.PRICE_PRODUCT, nameProduct1);
        String priceProduct2 = myAccountPage.getTextElement(driver, MyAccountPageUIs.PRICE_PRODUCT, nameProduct2);

        log.info("Step 1: Click compare prodcut 1");
        myAccountPage.clickIntoCompareProductButton(nameProduct1, "2");

        log.info("Step 2: Verify add compare prodcut 1 success");
        verifyEquals("The product has been added to your product comparison", myAccountPage.getTextElement(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG));

        log.info("Step 3: Click compare prodcut 2");
        myAccountPage.clickIntoCompareProductButton(nameProduct2, "2");
        log.info("Step 4: Verify add compare prodcut 2 success");
        verifyEquals("The product has been added to your product comparison", myAccountPage.getTextElement(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG));

        log.info("Step 5: Click compare product list footer");
        compareProductListPage = myAccountPage.clickIntoCompareProdcutListItemFooter("Compare products list");

        log.info("Step 6: Verify info Product 1");
        log.info("==== Price product 1 ====");
        verifyEquals(priceProduct1, compareProductListPage.getTextElement(driver, CompareProductListUIs.PRICE_PRODUCT, indexProduct1));
        log.info("==== Name product 1 ====");
        verifyEquals(nameProduct1, compareProductListPage.getTextElement(driver, CompareProductListUIs.NAME_PRODUCT,indexProduct1));
        log.info("==== Icon remove product 1 ====");
        verifyTrue(compareProductListPage.isControlDisplayed(driver,CompareProductListUIs.REMOVE_PRODUCT,indexProduct1));

        log.info("Step 7: Verify info Product 2");
        log.info("==== Price product 2 ====");
        verifyEquals(priceProduct2, compareProductListPage.getTextElement(driver, CompareProductListUIs.PRICE_PRODUCT, indexProduct2));
        log.info("==== Name product 2 ====");
        verifyEquals(nameProduct2, compareProductListPage.getTextElement(driver, CompareProductListUIs.NAME_PRODUCT,indexProduct2));
        log.info("==== Icon remove product 2 ====");
        verifyTrue(compareProductListPage.isControlDisplayed(driver,CompareProductListUIs.REMOVE_PRODUCT,indexProduct2));

        log.info("Step 8: Click Clear List button ");
        compareProductListPage.clickToElement(driver,CompareProductListUIs.CLEAR_LIST_BUTTON);

        log.info("Step 9: Message clear list is displayed");
        verifyTrue(compareProductListPage.isControlDisplayed(driver, CompareProductListUIs.MESSAGE_CLEAR_LIST));

        closeBrowserAndDriver(driver);


    }
}
