package order;

import PageObjects.*;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageUIs.ProductDetailPageUIs;

public class id001_orderProduct extends AbstractTest {
    WebDriver driver;
    MainPageObject mainPage;
    RegisterPageObject registerPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    ProductDetailPageObject productDetailPage;
    ShoppingCartPageObject shoppingCartPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = openMultiBrowser(browserName);
        mainPage = PageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        myAccountPage = (MyAccountPageObject) homePage.openMultiPageInItemHeader(driver, "ico-account");
        myAccountPage.hoverIntoMenuTopProduct(driver, "Computers");
        myAccountPage.clickIntoMenuTopProduct(driver, "Desktops");
    }

    @Test
    public void TC01_AddProductToShoppingCart() {
        String valueProcess, valueRam, valueHDD, valueOS, valueSoftware1st, valueSoftware2st, valueSoftware3st;
        String totalPrice, quantityProdcut;

        log.info("Step 1: Open Prodcut Detail");
        productDetailPage = myAccountPage.openProductDetails("Build your own computer");

        log.info("Step 2: Choose option");
        productDetailPage.selectDynamicDropDownConfig("Processor", "2.2 GHz Intel Pentium Dual-Core E2200");
        productDetailPage.selectDynamicDropDownConfig("RAM", "2 GB");

        productDetailPage.selectDynamicRadioButtonConfig("HDD", "400 GB [+$100.00]");
        productDetailPage.selectDynamicRadioButtonConfig("OS", "Vista Home [+$50.00]");

        productDetailPage.selectDynamicCheckboxConfig("Software", "Microsoft Office [+$50.00]");
        productDetailPage.selectDynamicCheckboxConfig("Software", "Acrobat Reader [+$10.00]");
        productDetailPage.selectDynamicCheckboxConfig("Software", "Total Commander [+$5.00]");

        log.info("Step 3: Get value option choose");
        valueProcess = productDetailPage.getDynamicValueDropdownConfig("Processor", "2.2 GHz Intel Pentium Dual-Core E2200");
        valueRam = productDetailPage.getDynamicValueDropdownConfig("RAM", "2 GB");

        valueHDD = productDetailPage.getDynamicValueRadioButtonConfig("HDD", "400 GB [+$100.00]");
        valueOS = productDetailPage.getDynamicValueRadioButtonConfig("OS", "Vista Home [+$50.00]");

        valueSoftware1st = productDetailPage.getDynamicValueCheckboxConfig("Software", "Microsoft Office [+$50.00]");
        valueSoftware2st = productDetailPage.getDynamicValueCheckboxConfig("Software", "Acrobat Reader [+$10.00]");
        valueSoftware3st = productDetailPage.getDynamicValueCheckboxConfig("Software", "Total Commander [+$5.00]");

        totalPrice = productDetailPage.getTotalPrice();

        //quantityProdcut = "Quantity: " +productDetailPage.getQuantityProduct();
        quantityProdcut = productDetailPage.getQuantityProduct();
        log.info("Step 4: Click button Add to cart");
        productDetailPage.clickIntoDynamicButtonWithClass(driver, "button-1 add-to-cart-button");


        log.info("Step 6: Verify count number product on Shopping card at Header page");
        verifyEquals("(" + quantityProdcut + ")", productDetailPage.getNumberProduct(driver, "cart-qty"));
        productDetailPage.clickCloseToastMsg(driver);

        log.info("Step 7: Hover into Shopping card item on header");
        productDetailPage.hoverIntoShoppingCartHeader(driver);

        log.info("Step 8: Verify count number product on Shopping card at popup hover");
        verifyEquals(quantityProdcut + " item(s)", productDetailPage.getNumberCountItemOnShoppingCartHeader(driver, "1"));


        log.info("Step 9: Verify attribute product on Shopping card at popup hover");
        String attributeProduct = "Processor: " + valueProcess + "\n"
                + "RAM: " + valueRam + "\n"
                + "HDD: " + valueHDD + "\n"
                + "OS: " + valueOS + "\n"
                + "Software: " + valueSoftware1st + "\n"
                + "Software: " + valueSoftware2st + "\n"
                + "Software: " + valueSoftware3st;
        verifyEquals(attributeProduct, productDetailPage.getTextNameProductOnShoppingCartHeader(driver));

        log.info("Step 10: Verify unit price product on Shopping card at popup hover");
        verifyEquals("Unit price: " + totalPrice, productDetailPage.getUnitPriceOnShoppingCartHeader(driver));

        log.info("Step 11: Verify quantity product on Shopping card at popup hover");
        verifyEquals("Quantity: " + quantityProdcut, productDetailPage.getQuantityProductOnShoppingCartHeader(driver));

    }

    @Test
    public void TC02_EditProductInShoppingCart() {
        String valueProcess, valueRam, valueHDD, valueOS, valueSoftware1st, valueSoftware2st, valueSoftware3st;
        String totalPrice, quantityProdcut;
        log.info("Step 1: Open Shopping Cart");
        shoppingCartPage = (ShoppingCartPageObject) productDetailPage.openMultiPageInItemHeader(driver, "ico-cart");

        log.info("Step 2: Click Edit item");
        productDetailPage = shoppingCartPage.clickEditItem();

        log.info("Step 3: Edit data");

        productDetailPage.selectDynamicDropDownConfig("Processor", "2.2 GHz Intel Pentium Dual-Core E2200");
        productDetailPage.selectDynamicDropDownConfig("RAM", "4GB [+$20.00]");

        productDetailPage.selectDynamicRadioButtonConfig("HDD", "320 GB");
        productDetailPage.selectDynamicRadioButtonConfig("OS", "Vista Home [+$50.00]");

        productDetailPage.selectDynamicUnCheckboxConfig("Software", "Acrobat Reader [+$10.00]");
        productDetailPage.selectDynamicUnCheckboxConfig("Software", "Total Commander [+$5.00]");
        productDetailPage.inputIntoDynamicTextbox(driver, "product_enteredQuantity_1", "2");

        log.info("Step 4: Get value option");
        valueProcess = productDetailPage.getDynamicValueDropdownConfig("Processor", "2.2 GHz Intel Pentium Dual-Core E2200");
        valueRam = productDetailPage.getDynamicValueDropdownConfig("RAM", "4GB [+$20.00]");

        valueHDD = productDetailPage.getDynamicValueRadioButtonConfig("HDD", "320 GB");
        valueOS = productDetailPage.getDynamicValueRadioButtonConfig("OS", "Vista Home [+$50.00]");

        valueSoftware1st = productDetailPage.getDynamicValueCheckboxConfig("Software", "Microsoft Office [+$50.00]");

        totalPrice = productDetailPage.getTotalPrice();
        quantityProdcut = productDetailPage.getQuantityProduct();

        log.info("Step 5: Click button Update Cart");
        productDetailPage.clickIntoDynamicButtonWithClass(driver, "button-1 add-to-cart-button");

        log.info("Step 6: Verify toast msg displayed");
        verifyEquals("The product has been added to your shopping cart", productDetailPage.getTextToastMessageDisplayed(driver));


        log.info("Step 7: Verify count number product on Shopping card at Header page");
        verifyEquals("(" + quantityProdcut + ")", productDetailPage.getNumberProduct(driver, "cart-qty"));
        productDetailPage.clickCloseToastMsg(driver);

        log.info("Step 8: Hover into Shopping card item on header");
        productDetailPage.hoverIntoShoppingCartHeader(driver);

        log.info("Step 9: Verify count number product on Shopping card at popup hover");
        verifyEquals(quantityProdcut + " item(s)", productDetailPage.getNumberCountItemOnShoppingCartHeader(driver, "2"));


        log.info("Step 10: Verify attribute product on Shopping card at popup hover");
        String attributeProduct = "Processor: " + valueProcess + "\n"
                + "RAM: " + valueRam + "\n"
                + "HDD: " + valueHDD + "\n"
                + "OS: " + valueOS + "\n"
                + "Software: " + valueSoftware1st;
        verifyEquals(attributeProduct, productDetailPage.getTextNameProductOnShoppingCartHeader(driver));

        log.info("Step 11: Verify unit price product on Shopping card at popup hover");
        verifyEquals("Unit price: " + totalPrice, productDetailPage.getUnitPriceOnShoppingCartHeader(driver));

        log.info("Step 12: Verify quantity product on Shopping card at popup hover");
        verifyEquals("Quantity: " + quantityProdcut, productDetailPage.getQuantityProductOnShoppingCartHeader(driver));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
