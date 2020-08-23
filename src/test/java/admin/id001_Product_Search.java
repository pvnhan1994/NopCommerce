package admin;

import adminPageObjects.DashboardPageObject;
import adminPageObjects.LoginPageObject;
import adminPageObjects.ProductsPageObject;
import commons.AbstractTest;
import commons.AdminPageGeneratorManager;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class id001_Product_Search extends AbstractTest {
    WebDriver driver;
    DashboardPageObject dashboardPage;
    ProductsPageObject productsPage;
    LoginPageObject loginPage;
    String ProductName = "Lenovo IdeaCentre 600 All-in-One PC";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = openMultiBrowser(browser);
        loginPage = AdminPageGeneratorManager.getLoginPage(driver);
        loginPage.inputIntoDynamicTextbox(driver, "Email", Constants.EMAIL_PAGEADMIN);
        loginPage.inputIntoDynamicTextbox(driver, "Password", Constants.PASSWORD_PAGEADMIN);
        dashboardPage = loginPage.clickIntoLoginButton();

        log.info("Step 1: Click Catalog menu");
        dashboardPage.clickIntoDynamicMenuBarMini(driver, "Catalog");

        log.info("Step 2: Click Products menu");
        productsPage = (ProductsPageObject) dashboardPage.openMultiPageInItemSubMenuBarMini(driver, "Products");

    }

    @Test
    public void TC01_SearchWithProductName() {

        log.info("Step 3: Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();
        log.info("Step 3: Input Product name into Search field");
        productsPage.inputIntoDynamicTextbox(driver, "SearchProductName", ProductName);

        log.info("Step 4: Click Search button");
        productsPage.clickIntoDynamicButtonWithID(driver, "search-products");

        log.info("Step 5: Verify 1 product displays in table");
        verifyEquals(1, productsPage.countMappingKeywordInTableResult(ProductName));
    }

    @Test
    public void TC02_SearchWithProductNameAndParentCategoryAndUnchecked() {
        log.info("Step : Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();
        log.info("Step 1: Input Product name into Search field");
        productsPage.inputIntoDynamicTextbox(driver, "SearchProductName", ProductName);

        log.info("Step 2: Select value in Search Category dropdown");
        productsPage.selectDynamicDropDownByID(driver, "SearchCategoryId", "Computers");

        log.info("Step 3: Uncheck to the Search SubCategories");
        productsPage.uncheckToTheSearchSubCategoriesCheckBox();

        log.info("Step 4: Click Search button");
        productsPage.clickIntoDynamicButtonWithID(driver, "search-products");

        log.info("Step 5: Verify message no data displayed");
        verifyTrue(productsPage.isMessageNoDataInTable("No data available in table"));


    }

    @Test
    public void TC03_SearchWithProductNameAndParentCategoryAndCheck() {
        log.info("Step : Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();

        log.info("Step 1: Input Product name into Search field");
        productsPage.inputIntoDynamicTextbox(driver, "SearchProductName", ProductName);

        log.info("Step 2: Select value in Search Category dropdown");
        productsPage.selectDynamicDropDownByID(driver, "SearchCategoryId", "Computers");

        log.info("Step 3: Check to the Search SubCategories");
        productsPage.checkToTheSearchSubCategoriesCheckBox();

        log.info("Step 4: Click Search button");
        productsPage.clickIntoDynamicButtonWithID(driver, "search-products");

        log.info("Step 5: Verify 1 product displays in table");
        verifyEquals(1, productsPage.countMappingKeywordInTableResult(ProductName));
    }

    @Test
    public void TC04_SearchWithProductNameAndChildCategory() {
        log.info("Step : Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();

        log.info("Step 1: Input Product name into Search field");
        productsPage.inputIntoDynamicTextbox(driver, "SearchProductName", ProductName);

        log.info("Step 2: Select value in Search Category dropdown");
        productsPage.selectDynamicDropDownByID(driver, "SearchCategoryId", "Computers >> Desktops");

        log.info("Step 3: Uncheck to the Search SubCategories");
        productsPage.uncheckToTheSearchSubCategoriesCheckBox();

        log.info("Step 4: Click Search button");
        productsPage.clickIntoDynamicButtonWithID(driver, "search-products");

        log.info("Step 5: Verify 1 product displays in table");
        verifyEquals(1, productsPage.countMappingKeywordInTableResult(ProductName));
    }

    @Test
    public void TC05_SearchWithProductNameAndManufacturer() {
        log.info("Step : Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();

        log.info("Step 1: Input Product name into Search field");
        productsPage.inputIntoDynamicTextbox(driver, "SearchProductName", ProductName);

        log.info("Step 2: Select value in Search Category dropdown");
        productsPage.selectDynamicDropDownByID(driver, "SearchCategoryId", "All");

        log.info("Step 3: Uncheck to the Search SubCategories");
        productsPage.uncheckToTheSearchSubCategoriesCheckBox();

        log.info("Step 4: Select value in Search Category dropdown");
        productsPage.selectDynamicDropDownByID(driver, "SearchManufacturerId", "Apple");

        log.info("Step 5: Click Search button");
        productsPage.clickIntoDynamicButtonWithID(driver, "search-products");

        log.info("Step 6: Verify message no data displayed");
        verifyTrue(productsPage.isMessageNoDataInTable("No data available in table"));
    }

    @Test
    public void TC06_GoDirectlyToProductSKU() {
        log.info("Step : Check expand/collapse Search component");
        productsPage.clickIntoIconExpandCollapseComponent();

        log.info("Step 1: Input Product SKU into SKU textbox");
        productsPage.inputIntoDynamicTextbox(driver, "GoDirectlyToSku", "LE_IC_600");

        log.info("Step 2: Click into Go SKU");
        productsPage.clickIntoDynamicButtonWithID(driver, "go-to-product-by-sku");

        log.info("Step 3: verify ");
        verifyEquals(ProductName, productsPage.getAttributeInTextbox(driver,"Name","value"));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
