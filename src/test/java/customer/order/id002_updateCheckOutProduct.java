package customer.order;

import customerPageObjects.*;
import commons.AbstractTest;
import commons.Constants;
import commons.CustomerPageGeneratorManager;
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
    OrderPageObject orderPage;
    String skuCode, priceUnit;
    String nameProduct = "Lenovo IdeaCentre 600 All-in-One PC";

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(String browser) {
        driver = openMultiBrowser(browser);
        mainPage = CustomerPageGeneratorManager.getMainPage(driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.registerAccount();
        homePage = registerPage.clickRegisterButton();
        myAccountPage = (MyAccountPageObject) homePage.openMultiPageInItemHeader(driver, "ico-account");
        myAccountPage.hoverIntoMenuTopProduct(driver, "Computers");
        myAccountPage.clickIntoMenuTopProduct(driver, "Desktops");
        log.info(" My Account Page - Step 1: Open Prodcut Detail");
        productDetailPage = myAccountPage.openProductDetails(nameProduct);
        skuCode = productDetailPage.getTextSkuCode();
        priceUnit = productDetailPage.getInforOverviewProduct("prices");

        log.info("Product Detail Page - Step 2: Click button Add to cart");
        productDetailPage.clickIntoDynamicButtonWithClass(driver, "button-1 add-to-cart-button");
        log.info("Product Detail Page - Step 3: Verify toast msg displayed");
        verifyEquals("The product has been added to your shopping cart", productDetailPage.getTextToastMessageDisplayed(driver));
        log.info("Product Detail Page - Step 4: Close toast msg");
        productDetailPage.clickCloseToastMsg(driver);
        log.info("Shopping Cart Page - Step 5: Open Shopping Cart");
        shoppingCartPage = (ShoppingCartPageObject) productDetailPage.openMultiPageInItemHeader(driver, "ico-cart");
    }


    public void TC04_UpdateShoppingCart() {
        String qualityUpdate = "5";
        log.info("Shopping Cart Page - Step 6: Input value updateQuality");
        shoppingCartPage.inputNumberForUpdateQtyProduct(qualityUpdate);

        log.info("Shopping Cart Page - Step 7: Click Update button");
        shoppingCartPage.clickIntoDynamicButtonWithClass(driver, "button-2 update-cart-button");

        log.info("Shopping Cart Page - Step 8: Verify sub-total displays correct");
        verifyEquals(shoppingCartPage.getActualValueSubTotal(priceUnit, qualityUpdate), shoppingCartPage.getExpectedValueSubTotal());

    }

    public void TC05_CheckOut_Order() {
        String addressCompany = "32145324 AVASD";
        String country = "Viet Nam";
        String city = "Da Nang";
        String address1 = "29 Ho Xuan Huong";
        String address2 = "203 Ong Ich Khiem";
        String zipCode = "550000";
        String phoneNumber = "0935602450";
        String faxNumber = "123456789";

        log.info("Shopping Cart Page - Step 6 : Click Checkbox agree");
        shoppingCartPage.selectDynamicCheckbox(driver, "termsofservice");
        log.info("Checkout Page - Step 6.1: Click Checkout button");
        checkOutPage = shoppingCartPage.clickCheckOutButton();

        log.info("Checkout Page - Step 7: Checkout screen is displays");
        log.info("Checkout Page - Step 7.1: Header screen is displays");
        verifyTrue(checkOutPage.isMessageInHeaderDisplayed());
        log.info("Checkout Page - Step 7.2: Page Billing address displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Billing address"));


        log.info("Checkout Page - Step 8: Input infor");
        checkOutPage.selectDynamicCheckbox(driver, "ShipToSameAddress");
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Company", addressCompany);
        checkOutPage.selectDynamicDropDown(driver, "BillingNewAddress.CountryId", country);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_City", city);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Address1", address1);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Address2", address2);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_ZipPostalCode", zipCode);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_PhoneNumber", phoneNumber);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_FaxNumber", faxNumber);

        log.info("Checkout Page - Step 9: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Billing address");

        log.info("Checkout Page - Step 10: Page Shipping Method displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Shipping method"));

        log.info("Checkout Page - Step 11: Select any Shipping method");
        checkOutPage.selectDynamicCheckboxWithLabelText(driver, "Ground ($0.00)");
        log.info("Checkout Page - Step 12: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Shipping method");


        log.info("Checkout Page - Step 13: Page Payment Method displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Payment method"));

        log.info("Checkout Page - Step 14: Select any Payment method");
        checkOutPage.selectDynamicCheckboxWithLabelText(driver, "Check / Money Order");

        log.info("Checkout Page - Step 15: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Payment method");
        //======================
        log.info("Checkout Page - Step 16: Page Payment information displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Payment information"));

        log.info("Checkout Page - Step 17: Verify Body Payment information displays");
        verifyTrue(checkOutPage.isBodyPaymentInformationDisplayed());

        log.info("Checkout Page - Step 18: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Payment information");

        log.info("Checkout Page - Step 19: Verify Billing Address/ Shipping Address/ Payment / Shipping infor");

        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "email"));
        verifyEquals("Phone: " + phoneNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "phone"));
        verifyEquals("Fax: " + faxNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "fax"));
        verifyEquals(addressCompany, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "company"));
        verifyEquals(address1, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address1"));
        verifyEquals(address2, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address2"));
        verifyEquals(city + "," + zipCode, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "city-state-zip"));
        verifyEquals("Viet Nam", checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "country"));

        log.info("Checkout Page - Step 20: Verify Shipping Address infor");
        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "email"));
        verifyEquals("Phone: " + phoneNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "phone"));
        verifyEquals("Fax: " + faxNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "fax"));
        verifyEquals(addressCompany, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "company"));
        verifyEquals(address1, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address1"));
        verifyEquals(address2, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address2"));
        verifyEquals(city + "," + zipCode, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "city-state-zip"));
        verifyEquals("Viet Nam", checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "country"));

        log.info("Checkout Page - Step 21: Verify Payment method infor");
        verifyEquals("Payment Method: Check / Money Order ", checkOutPage.getDynamicInforInConfirmOrder(driver, "Payment", "payment-method"));

        log.info("Checkout Page - Step 22: Verify Shipping method infor");
        verifyEquals("Shipping Method: Ground ", checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping", "shipping-method"));

        log.info("Checkout Page - Step 23: Verify TableData infor");
        verifyEquals(skuCode, checkOutPage.getDynamicInfoTableData(driver, "sku", "span"));
        verifyEquals(nameProduct, checkOutPage.getDynamicInfoTableData(driver, "product", "a"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInfoTableData(driver, "unit-price", "span"));
        verifyEquals("1", checkOutPage.getDynamicInfoTableData(driver, "quantity", "span"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInfoTableData(driver, "subtotal", "span"));

        log.info("Checkout Page - Step 24: Verify Infor Cart Footer");
        verifyEquals(priceUnit, checkOutPage.getDynamicInforCartFooter(driver, "Sub-Total"));
        verifyEquals("$0.00", checkOutPage.getDynamicInforCartFooter(driver, "Shipping"));
        verifyEquals("$0.00", checkOutPage.getDynamicInforCartFooter(driver, "Tax"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInforCartFooter(driver, "Total"));

        log.info("Checkout Page - Step 25: Confirm order");
        checkOutPage.clickIntoDynamicContinuteButton("Confirm order");

        log.info("Checkout Page - Step 26: Verify THANK YOU message displayed");
        verifyTrue(checkOutPage.isOrderPageSuccessDisplayed());

        String orderNumber = checkOutPage.getOrderNumber();
        log.info("Checkout Page - Step 27: Click button Continute");
        checkOutPage.clickIntoDynamicButtonByJS(driver, "button-1 order-completed-continue-button");

        log.info("Checkout Page - Step 28: Open My Account screen");
        myAccountPage = (MyAccountPageObject) checkOutPage.openMultiPageInItemHeader(driver, "ico-account");

        log.info("Order Page - Step 29: Open Order Page");
        orderPage = (OrderPageObject) myAccountPage.openMultiPageInLeftBar(driver, "Orders");

        log.info("Order Page - Step 30: Verify order number");
        verifyEquals(orderNumber, orderPage.getOrderNumber());

        log.info("Order Page - Step 31: Click Detail item");
        orderPage.clickDetailItem();

        log.info("Order Page - Step 32: Verify Billing Address infor");

        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "email"));
        verifyEquals("Phone: " + phoneNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "phone"));
        verifyEquals("Fax: " + faxNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "fax"));
        verifyEquals(addressCompany, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "company"));
        verifyEquals(address1, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address1"));
        verifyEquals(address2, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address2"));
        verifyEquals(city + "," + zipCode, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "city-state-zip"));
        verifyEquals("Viet Nam", orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "country"));

        log.info("Order Page - Step 33: Verify Shipping Address infor");
        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "email"));
        verifyEquals("Phone: " + phoneNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "phone"));
        verifyEquals("Fax: " + faxNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "fax"));
        verifyEquals(addressCompany, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "company"));
        verifyEquals(address1, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address1"));
        verifyEquals(address2, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address2"));
        verifyEquals(city + "," + zipCode, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "city-state-zip"));
        verifyEquals("Viet Nam", orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "country"));

        log.info("Order Page - Step 34: Verify Payment method infor");
        verifyEquals("Payment Method: Check / Money Order ", orderPage.getDynamicInforInConfirmOrder(driver, "Payment", "payment-method"));

        log.info("Order Page - Step 35: Verify Shipping method infor");
        verifyEquals("Shipping Method: Ground ", orderPage.getDynamicInforInConfirmOrder(driver, "Shipping", "shipping-method"));
        log.info("Order Page - Step 36: Verify TableData infor");

        verifyEquals(skuCode, orderPage.getDynamicInfoTableData(driver, "sku", "span"));
        verifyEquals(nameProduct, orderPage.getDynamicInfoTableData(driver, "product", "a"));
        verifyEquals(priceUnit, orderPage.getDynamicInfoTableData(driver, "unit-price", "span"));
        verifyEquals("1", orderPage.getDynamicInfoTableData(driver, "quantity", "span"));
        verifyEquals(priceUnit, orderPage.getDynamicInfoTableData(driver, "total", "span"));

        log.info("Order Page - Step 37 : Verify Infor Cart Footer");
        verifyEquals(priceUnit, orderPage.getDynamicInforCartFooter(driver, "Sub-Total"));
        verifyEquals("$0.00", orderPage.getDynamicInforCartFooter(driver, "Shipping"));
        verifyEquals("$0.00", orderPage.getDynamicInforCartFooter(driver, "Tax"));
        verifyEquals(priceUnit, orderPage.getDynamicInforCartFooter(driver, "Order Total"));

        log.info("Order Page - Step 38: Verify info Order Overview");
        verifyEquals("Order Date: " + getTimeCurrent(), orderPage.getOrderDay());


    }
    @Test
    public void TC06_(){
        String addressCompany = "32145324 AVASD";
        String country = "Viet Nam";
        String city = "Da Nang";
        String address1 = "29 Ho Xuan Huong";
        String address2 = "203 Ong Ich Khiem";
        String zipCode = "550000";
        String phoneNumber = "0935602450";
        String faxNumber = "123456789";

        log.info("Shopping Cart Page - Step 6 : Click Checkbox agree");
        shoppingCartPage.selectDynamicCheckbox(driver, "termsofservice");
        log.info("Checkout Page - Step 6.1: Click Checkout button");
        checkOutPage = shoppingCartPage.clickCheckOutButton();

        log.info("Checkout Page - Step 7: Checkout screen is displays");
        log.info("Checkout Page - Step 7.1: Header screen is displays");
        verifyTrue(checkOutPage.isMessageInHeaderDisplayed());
        log.info("Checkout Page - Step 7.2: Page Billing address displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Billing address"));


        log.info("Checkout Page - Step 8: Input infor");
        checkOutPage.selectDynamicCheckbox(driver, "ShipToSameAddress");
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Company", addressCompany);
        checkOutPage.selectDynamicDropDown(driver, "BillingNewAddress.CountryId", country);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_City", city);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Address1", address1);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_Address2", address2);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_ZipPostalCode", zipCode);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_PhoneNumber", phoneNumber);
        checkOutPage.inputIntoDynamicTextbox(driver, "BillingNewAddress_FaxNumber", faxNumber);

        log.info("Checkout Page - Step 9: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Billing address");

        log.info("Checkout Page - Step 10: Page Shipping Method displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Shipping method"));

        log.info("Checkout Page - Step 11: Select any Shipping method");
        checkOutPage.selectDynamicCheckboxWithLabelText(driver, "Ground ($0.00)");
        log.info("Checkout Page - Step 12: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Shipping method");


        log.info("Checkout Page - Step 13: Page Payment Method displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Payment method"));

        log.info("Checkout Page - Step 14: Select any Payment method");
        checkOutPage.selectDynamicCheckboxWithLabelText(driver, "Credit Card");

        log.info("Checkout Page - Step 15: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Payment method");

        log.info("Checkout Page - Step 16: Page Payment information displays");
        verifyTrue(checkOutPage.isDynamicStepToCheckOutPageDisplayed("Payment information"));

        log.info("Checkout Page - Step 17: Input infor Payment information");
        checkOutPage.inputIntoDynamicTextbox(driver,"CardholderName","Nhan Phan");
        checkOutPage.inputIntoDynamicTextbox(driver,"CardNumber","4242424242424242");
        checkOutPage.inputIntoDynamicTextbox(driver,"CardCode","123");
        checkOutPage.selectDynamicDropDown(driver,"CreditCardType","Visa");
        checkOutPage.selectDynamicDropDown(driver,"ExpireMonth","01");
        checkOutPage.selectDynamicDropDown(driver,"ExpireYear","2022");

        log.info("Checkout Page - Step 18: Click Continute button");
        checkOutPage.clickIntoDynamicContinuteButton("Payment information");

        log.info("Checkout Page - Step 19: Verify Billing Address/ Shipping Address/ Payment / Shipping infor");

        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "email"));
        verifyEquals("Phone: " + phoneNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "phone"));
        verifyEquals("Fax: " + faxNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "fax"));
        verifyEquals(addressCompany, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "company"));
        verifyEquals(address1, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address1"));
        verifyEquals(address2, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address2"));
        verifyEquals(city + "," + zipCode, checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "city-state-zip"));
        verifyEquals("Viet Nam", checkOutPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "country"));

        log.info("Checkout Page - Step 20: Verify Shipping Address infor");
        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "email"));
        verifyEquals("Phone: " + phoneNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "phone"));
        verifyEquals("Fax: " + faxNumber, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "fax"));
        verifyEquals(addressCompany, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "company"));
        verifyEquals(address1, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address1"));
        verifyEquals(address2, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address2"));
        verifyEquals(city + "," + zipCode, checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "city-state-zip"));
        verifyEquals("Viet Nam", checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "country"));

        log.info("Checkout Page - Step 21: Verify Payment method infor");
        verifyEquals("Payment Method: Credit Card", checkOutPage.getDynamicInforInConfirmOrder(driver, "Payment", "payment-method"));

        log.info("Checkout Page - Step 22: Verify Shipping method infor");
        verifyEquals("Shipping Method: Ground", checkOutPage.getDynamicInforInConfirmOrder(driver, "Shipping", "shipping-method"));

        log.info("Checkout Page - Step 23: Verify TableData infor");
        verifyEquals(skuCode, checkOutPage.getDynamicInfoTableData(driver, "sku", "span"));
        verifyEquals(nameProduct, checkOutPage.getDynamicInfoTableData(driver, "product", "a"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInfoTableData(driver, "unit-price", "span"));
        verifyEquals("1", checkOutPage.getDynamicInfoTableData(driver, "quantity", "span"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInfoTableData(driver, "subtotal", "span"));

        log.info("Checkout Page - Step 24: Verify Infor Cart Footer");
        verifyEquals(priceUnit, checkOutPage.getDynamicInforCartFooter(driver, "Sub-Total"));
        verifyEquals("$0.00", checkOutPage.getDynamicInforCartFooter(driver, "Shipping"));
        verifyEquals("$0.00", checkOutPage.getDynamicInforCartFooter(driver, "Tax"));
        verifyEquals(priceUnit, checkOutPage.getDynamicInforCartFooter(driver, "Total"));

        log.info("Checkout Page - Step 25: Confirm order");
        checkOutPage.clickIntoDynamicContinuteButton("Confirm order");

        log.info("Checkout Page - Step 26: Verify THANK YOU message displayed");
        verifyTrue(checkOutPage.isOrderPageSuccessDisplayed());

        String orderNumber = checkOutPage.getOrderNumber();
        log.info("Checkout Page - Step 27: Click button Continute");
        checkOutPage.clickIntoDynamicButtonByJS(driver, "button-1 order-completed-continue-button");

        log.info("Checkout Page - Step 28: Open My Account screen");
        myAccountPage = (MyAccountPageObject) checkOutPage.openMultiPageInItemHeader(driver, "ico-account");

        log.info("Order Page - Step 29: Open Order Page");
        orderPage = (OrderPageObject) myAccountPage.openMultiPageInLeftBar(driver, "Orders");

        log.info("Order Page - Step 30: Verify order number");
        verifyEquals(orderNumber, orderPage.getOrderNumber());

        log.info("Order Page - Step 31: Click Detail item");
        orderPage.clickDetailItem();

        log.info("Order Page - Step 32: Verify Billing Address infor");

        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "email"));
        verifyEquals("Phone: " + phoneNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "phone"));
        verifyEquals("Fax: " + faxNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "fax"));
        verifyEquals(addressCompany, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "company"));
        verifyEquals(address1, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address1"));
        verifyEquals(address2, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "address2"));
        verifyEquals(city + "," + zipCode, orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "city-state-zip"));
        verifyEquals("Viet Nam", orderPage.getDynamicInforInConfirmOrder(driver, "Billing Address", "country"));

        log.info("Order Page - Step 33: Verify Shipping Address infor");
        verifyEquals(Constants.LAST_NAME + " " + Constants.FIRST_NAME, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "name"));
        verifyEquals("Email: " + Constants.EMAIL, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "email"));
        verifyEquals("Phone: " + phoneNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "phone"));
        verifyEquals("Fax: " + faxNumber, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "fax"));
        verifyEquals(addressCompany, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "company"));
        verifyEquals(address1, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address1"));
        verifyEquals(address2, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "address2"));
        verifyEquals(city + "," + zipCode, orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "city-state-zip"));
        verifyEquals("Viet Nam", orderPage.getDynamicInforInConfirmOrder(driver, "Shipping Address", "country"));

        log.info("Order Page - Step 34: Verify Payment method infor");
        verifyEquals("Payment Method: Credit Card", orderPage.getDynamicInforInConfirmOrder(driver, "Payment", "payment-method"));

        log.info("Order Page - Step 35: Verify Shipping method infor");
        verifyEquals("Shipping Method: Ground", orderPage.getDynamicInforInConfirmOrder(driver, "Shipping", "shipping-method"));
        log.info("Order Page - Step 36: Verify TableData infor");

        verifyEquals(skuCode, orderPage.getDynamicInfoTableData(driver, "sku", "span"));
        verifyEquals(nameProduct, orderPage.getDynamicInfoTableData(driver, "product", "a"));
        verifyEquals(priceUnit, orderPage.getDynamicInfoTableData(driver, "unit-price", "span"));
        verifyEquals("1", orderPage.getDynamicInfoTableData(driver, "quantity", "span"));
        verifyEquals(priceUnit, orderPage.getDynamicInfoTableData(driver, "total", "span"));

        log.info("Order Page - Step 37 : Verify Infor Cart Footer");
        verifyEquals(priceUnit, orderPage.getDynamicInforCartFooter(driver, "Sub-Total"));
        verifyEquals("$0.00", orderPage.getDynamicInforCartFooter(driver, "Shipping"));
        verifyEquals("$0.00", orderPage.getDynamicInforCartFooter(driver, "Tax"));
        verifyEquals(priceUnit, orderPage.getDynamicInforCartFooter(driver, "Order Total"));

        log.info("Order Page - Step 38: Verify info Order Overview");
        verifyEquals("Order Date: " + getTimeCurrent(), orderPage.getOrderDay());

    }
    @AfterMethod
    public void afterMethos() {
        closeBrowserAndDriver(driver);
    }
}
