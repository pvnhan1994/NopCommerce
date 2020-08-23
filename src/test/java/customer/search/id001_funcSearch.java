package customer.search;

import customerPageObjects.*;
import commons.AbstractTest;
import commons.CustomerPageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class id001_funcSearch extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    SearchPageObject searchPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = CustomerPageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        searchPage = (SearchPageObject) homePage.openMultiPageInFooter(driver, "Search");

    }

    @Test
    public void TC001_DontInputData() {
        log.info("Step 1: Dont input data");
        searchPage.inputIntoDynamicTextbox(driver, "q", "");

        log.info("Step 2: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 3: Validate message is displayed");
        verifyEquals("Search term minimum length is 3 characters", searchPage.getValidateMessageSearch("warning"));

    }

    @Test
    public void TC002_InputDataNotExist() {
        log.info("Step 1: Input data");
        searchPage.inputIntoDynamicTextbox(driver, "q", "Macbook Pro2050");

        log.info("Step 2: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 3: Validate message is displayed");
        verifyEquals("No products were found that matched your criteria.", searchPage.getValidateMessageSearch("no-result"));
    }

    @Test
    public void TC003_InputDataExistRelative() {
        log.info("Step 1: Input data");
        searchPage.inputIntoDynamicTextbox(driver, "q", "Lenovo");

        log.info("Step 2: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 3: Validate message is displayed");
        verifyEquals(2, searchPage.countProductRelativeInSearch("Lenovo"));
    }

    @Test
    public void TC004_InputDataOnly1ProductExis() {
        log.info("Step 1: Input data");
        searchPage.inputIntoDynamicTextbox(driver, "q", "ThinkPad X1 Carbon");

        log.info("Step 2: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 3: Validate message is displayed");
        verifyEquals(1, searchPage.countProductRelativeInSearch("Lenovo Thinkpad X1 Carbon Laptop"));
    }

    @Test
    public void TC005_AdvancedSearchWithParentCategories() {
        log.info("Step 1: Input data");
        searchPage.inputIntoDynamicTextbox(driver, "q", "Apple Macbook Pro");

        log.info("Step 2: Check avanced search");
        searchPage.selectDynamicRadioCheckboxWithID(driver, "adv");

        log.info("Step 3: Select Category is Computers");
        searchPage.selectDynamicDropDownByID(driver, "cid", "Computers");

        log.info("Step 4: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 5: Validate message is displayed");
        verifyEquals("No products were found that matched your criteria.", searchPage.getValidateMessageSearch("no-result"));

    }

    @Test
    public void TC006_AdvancedSearchWithSubCategories() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");
        searchPage.selectDynamicRadioCheckboxWithID(driver, "isc");

        log.info("Step 5: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 6: Validate message is displayed");
        verifyEquals(1, searchPage.countProductRelativeInSearch("Apple MacBook Pro 13-inch"));

    }

    @Test
    public void TC007_AdvancedSearchWithIncorrectManufacturer() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");

        log.info("Step 5: Select incorrect Manufacturer");
        searchPage.selectDynamicDropDownByID(driver, "mid", "HP");

        log.info("Step 6: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 7: Validate message is displayed");
        verifyEquals("No products were found that matched your criteria.", searchPage.getValidateMessageSearch("no-result"));
    }

    @Test
    public void TC008_AdvancedSearchWithCorrectManufacturer() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");

        log.info("Step 5: Select Correct Manufacturer");
        searchPage.selectDynamicDropDownByID(driver, "mid", "Apple");

        log.info("Step 6: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 7: Validate message is displayed");
        verifyEquals(1, searchPage.countProductRelativeInSearch("Apple MacBook Pro 13-inch"));

    }

    @Test
    public void TC009_AdvancedSearchWithScopePriceRange() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");

        log.info("Step 5: Select Correct Manufacturer");

        log.info("Step 6: Input price range");
        searchPage.inputIntoDynamicTextbox(driver, "pf", "1000");
        searchPage.inputIntoDynamicTextbox(driver, "pt", "2000");

        log.info("Step 7: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 8: Validate message is displayed");
        verifyEquals(1, searchPage.countProductRelativeInSearch("Apple MacBook Pro 13-inch"));

    }

    @Test
    public void TC010_AdvancedSearchWithOutOfScopePriceRange() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");

        log.info("Step 5: Select Correct Manufacturer");

        log.info("Step 6: Input price range");
        searchPage.inputIntoDynamicTextbox(driver, "pf", "1900");
        searchPage.inputIntoDynamicTextbox(driver, "pt", "5000");

        log.info("Step 7: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 8: Validate message is displayed");
        verifyEquals("No products were found that matched your criteria.", searchPage.getValidateMessageSearch("no-result"));

    }

    @Test
    public void TC011_AdvancedSearchMoreThanProductPrice() {
        log.info("Step 1: Input data");

        log.info("Step 2: Check avanced search");

        log.info("Step 3: Select Category is Computers");

        log.info("Step 4: Check Automatically search sub categories");

        log.info("Step 5: Select Correct Manufacturer");

        log.info("Step 6: Input price range");
        searchPage.inputIntoDynamicTextbox(driver, "pf", "1000");
        searchPage.inputIntoDynamicTextbox(driver, "pt", "1700");

        log.info("Step 7: Click Search button");
        searchPage.clickIntoDynamicButtonWithClass(driver, "button-1 search-button");

        log.info("Step 8: Validate message is displayed");
        verifyEquals("No products were found that matched your criteria.", searchPage.getValidateMessageSearch("no-result"));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
