package wishList_compare_recentView;

import customerPageObjects.*;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class id002_compareProduct extends AbstractTest {

    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    CompareProductListPageObject compareProductListPage;


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
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        myAccountPage = (MyAccountPageObject) homePage.openMultiPageInItemHeader(driver,"ico-account");
        myAccountPage.hoverIntoMenuTopProduct("Computers");
        myAccountPage.clickIntoMenuTopProduct("Desktops");

        String priceProduct1 = myAccountPage.getPriceProduct(nameProduct1);
        String priceProduct2 = myAccountPage.getPriceProduct(nameProduct2);

        log.info("Step 1: Click compare prodcut 1");
        myAccountPage.clickIntoCompareProductButton(nameProduct1, "2");

        log.info("Step 2: Verify add compare prodcut 1 success");
        verifyEquals("The product has been added to your product comparison", myAccountPage.getTextToastMessageDisplayed(driver));

        log.info("Step 3: Click compare prodcut 2");
        myAccountPage.clickIntoCompareProductButton(nameProduct2, "2");
        log.info("Step 4: Verify add compare prodcut 2 success");
        verifyEquals("The product has been added to your product comparison", myAccountPage.getTextToastMessageDisplayed(driver));

        log.info("Step 5: Click compare product list footer");
        compareProductListPage = (CompareProductListPageObject) myAccountPage.openMultiPageInFooter(driver, "Compare products list");

        log.info("Step 6: Verify info Product 1");
        log.info("==== Price product 1 ====");
        verifyEquals(priceProduct1, compareProductListPage.getPriceProduct(indexProduct1));
        log.info("==== Name product 1 ====");
        verifyEquals(nameProduct1, compareProductListPage.getNameProduct(indexProduct1));
        log.info("==== Icon remove product 1 ====");
        verifyTrue(compareProductListPage.isRemoveIconDisplayed(indexProduct1));

        log.info("Step 7: Verify info Product 2");
        log.info("==== Price product 2 ====");
        verifyEquals(priceProduct2, compareProductListPage.getPriceProduct(indexProduct2));
        log.info("==== Name product 2 ====");
        verifyEquals(nameProduct2, compareProductListPage.getNameProduct(indexProduct2));
        log.info("==== Icon remove product 2 ====");
        verifyTrue(compareProductListPage.isRemoveIconDisplayed(indexProduct2));

        log.info("Step 8: Click Clear List button ");
        compareProductListPage.clickIntoClearListButton();

        log.info("Step 9: Message clear list is displayed");
        verifyTrue(compareProductListPage.isMessageClearListSuccessDisplayed());

    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
