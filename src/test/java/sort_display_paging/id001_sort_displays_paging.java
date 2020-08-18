package sort_display_paging;

import customerPageObjects.MainPageObject;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import customerPageUIs.MainPageUI;


public class id001_sort_displays_paging extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = PageGeneratorManager.getMainPage(driver);
        mainPage.hoverIntoMenuTopProduct(driver, "Computers");
        mainPage.clickIntoMenuTopProduct(driver, "Notebooks");
    }

    @Test
    public void TC001_SortAtoZ() {
        log.info("Step 1: Select option orderby");
        mainPage.selectDynamicDropDownByID(driver, "products-orderby", "Name: A to Z");

        log.info("Step 2: Verify orderby correct");
        verifyTrue(mainPage.isDataSortedAsceding(driver, MainPageUI.NAME_PRODUCT));
    }

    @Test
    public void TC002_SortZtoA() {
        log.info("Step 1: Select option orderby");
        mainPage.selectDynamicDropDownByID(driver, "products-orderby", "Name: Z to A");

        log.info("Step 2: Verify orderby correct");
        verifyTrue(mainPage.isDataSortedDesceding(driver, MainPageUI.NAME_PRODUCT));
    }

    @Test
    public void TC003_SortLowtoHigh() {
        log.info("Step 1: Select option orderby");
        mainPage.selectDynamicDropDownByID(driver, "products-orderby", "Price: Low to High");

        log.info("Step 2: Verify orderby correct");
        verifyTrue(mainPage.isDataSortedAsceding(driver, MainPageUI.PRICE_PRODUCT));
    }

    @Test
    public void TC004_SortHightoLow() {
        log.info("Step 1: Select option orderby");
        mainPage.selectDynamicDropDownByID(driver, "products-orderby", "Price: High to Low");

        log.info("Step 2: Verify orderby correct");
        verifyTrue(mainPage.isDataSortedDesceding(driver, MainPageUI.PRICE_PRODUCT));
    }

    @Test
    public void TC005_DisplayWith3ProductPerPaging() {
        log.info("Step 1: Select option pagesize");
        mainPage.selectDynamicDropDownByID(driver, "products-pagesize", "3");

        log.info("Step 2: Verify pagesize correct");
        verifyTrue(mainPage.isItemProductDisplayedCorrect(driver, 3));

        log.info("Step 3: Verify Page Bar displayed");
        verifyTrue(mainPage.isControlDisplayed(driver, MainPageUI.PAGING_BAR));

        log.info("Step 4: Verify Next icon displayed");
        verifyTrue(mainPage.isControlDisplayed(driver, MainPageUI.PAGING_NAVIGATE, "Next"));

        log.info("Step 5: Click second page");
        mainPage.clickIntoItemNavigatePaging("2");

        log.info("Step 6: Verify Previous displayed");
        verifyTrue(mainPage.isControlDisplayed(driver, MainPageUI.PAGING_NAVIGATE, "Previous"));


    }

    @Test
    public void TC006_DisplayWith6ProductPerPaging() {
        log.info("Step 1: Select option pagesize");
        mainPage.selectDynamicDropDownByID(driver, "products-pagesize", "6");

        log.info("Step 2: Verify pagesize correct");
        verifyTrue(mainPage.isItemProductDisplayedCorrect(driver, 6));

        log.info("Step 3: Verify Page Bar undisplayed");
        verifyTrue(mainPage.isControlUndisplayed(driver, MainPageUI.PAGING_BAR));
    }

    @Test
    public void TC007_DisplayWith9ProductPerPaging() {
        log.info("Step 1: Select option pagesize");
        mainPage.selectDynamicDropDownByID(driver, "products-pagesize", "9");

        log.info("Step 2: Verify pagesize correct");
        verifyTrue(mainPage.isItemProductDisplayedCorrect(driver, 9));

        log.info("Step 3: Verify Page Bar undisplayed");
        verifyTrue(mainPage.isControlUndisplayed(driver, MainPageUI.PAGING_BAR));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
