package customer.wishList_compare_recentView;

import customerPageObjects.MainPageObject;
import customerPageObjects.ReviewProductPageObject;
import commons.AbstractTest;
import commons.CustomerPageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class id003_reviewProduct extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    ReviewProductPageObject reviewProductPage;

    String namePr1st = "Apple MacBook Pro 13-inch";
    String namePr2st = "Asus N551JK-XO076H Laptop";
    String namePr3st = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
    String namePr4st = "HP Spectre XT Pro UltraBook";
    String namePr5st = "Lenovo Thinkpad X1 Carbon Laptop";
    String namePr6st = "Samsung Series 9 NP900X4C Premium Ultrabook";

    @Parameters("browser")
    @Test(alwaysRun = true)
    public void TC003_reviewProduct(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = CustomerPageGeneratorManager.getMainPage(driver);
        mainPage.hoverIntoMenuTopProduct(driver, "Computers");
        mainPage.clickIntoMenuTopProduct(driver, "Notebooks");

        log.info("Step 1: Click product for review");
        mainPage.openProductDetails(namePr1st);
        mainPage.backToPage(driver);

        mainPage.openProductDetails(namePr2st);
        mainPage.backToPage(driver);

        mainPage.openProductDetails(namePr3st);
        mainPage.backToPage(driver);

        mainPage.openProductDetails(namePr4st);
        mainPage.backToPage(driver);

        mainPage.openProductDetails(namePr5st);
        mainPage.backToPage(driver);

        mainPage.openProductDetails(namePr6st);
        mainPage.backToPage(driver);

        log.info("Step 2: Click into Review products page");
        reviewProductPage = (ReviewProductPageObject) mainPage.openMultiPageInFooter(driver, "Recently viewed products");

        log.info("Step 3: Verify product displayed");
        verifyTrue(reviewProductPage.isProductDisplayed(namePr4st));
        verifyTrue(reviewProductPage.isProductDisplayed(namePr5st));
        verifyTrue(reviewProductPage.isProductDisplayed(namePr6st));

        log.info("Step 4: Verify product undisplayed");
        verifyFalse(reviewProductPage.isProductUndisplayed(namePr1st));
        verifyFalse(reviewProductPage.isProductUndisplayed(namePr2st));
        verifyFalse(reviewProductPage.isProductUndisplayed(namePr3st));
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }


}
