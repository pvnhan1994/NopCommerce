package account;

import PageObjects.*;
import commons.AbstractPageUIs;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class id003_myAccount extends AbstractTest {
    WebDriver driver;

    MainPageObject mainPage;
    ChangePasswordPageObject changePasswordPage;
    HomePageObject homePage;
    MyAccountPageObject myAccountPage;
    CustomerInfoPageObject customerInfoPage;
    RegisterPageObject registerPage;
    AddressPageObject addressPage;
    LoginPageObject loginPage;
    MyProductReviewsPageObject myProductReviewPage;
    String password = "123123";
    String newPassword = "123123123";
    String email = "alodsadsads1a5t493@gmail.com";
    String firstName = "Nhan";
    String lastName = "Phan";
    String emailEdit = "editalodsa" + randomDataTest() + "@gmail.com";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = openMultiBrowser(browser);
        mainPage = PageGeneratorManager.getMainPage(driver);
        System.out.println("id Driver:" + driver);
        registerPage = mainPage.clickRegisterItem();
        registerPage.inputIntoDynamicTextbox(driver, "FirstName", firstName);
        registerPage.inputIntoDynamicTextbox(driver, "LastName", lastName);
        registerPage.inputIntoDynamicTextbox(driver, "Email", email);
        registerPage.inputIntoDynamicTextbox(driver, "Password", password);
        registerPage.inputIntoDynamicTextbox(driver, "ConfirmPassword", password);
        homePage = registerPage.clickRegisterButton();
        myAccountPage = homePage.clickToMyAccountItem();
    }

    @Test
    public void TC01_CustomerInfo() {
        log.info("Step 1: Click Customer Info menu");
        customerInfoPage = myAccountPage.clickCustomerInfoMenuBar();

        log.info("Step 2: Select Gender");
        customerInfoPage.selectDynamicRadioCheckbox(driver, "gender-male");

        log.info("Step 3: Edit First Name");
        customerInfoPage.inputIntoDynamicTextbox(driver, AbstractPageUIs.FIRSTNAME_ID, "Tony");

        log.info("Step 4: Edit Last Name");
        customerInfoPage.inputIntoDynamicTextbox(driver, AbstractPageUIs.LASTNAME_ID, "Luca");

        log.info("Step 5: Edit DOB");
        customerInfoPage.selectDynamicDropDown(driver, "DateOfBirthDay", "17");
        customerInfoPage.selectDynamicDropDown(driver, "DateOfBirthMonth", "November");
        customerInfoPage.selectDynamicDropDown(driver, "DateOfBirthYear", "1994");

        log.info("Step 6: Edit Email");
        customerInfoPage.inputIntoDynamicTextbox(driver, AbstractPageUIs.EMAIL_ID, emailEdit);

        log.info("Step 7: Edit Company name");
        customerInfoPage.inputIntoDynamicTextbox(driver, AbstractPageUIs.COMPANY_ID, "AutoCompany");

        log.info("Step 8: Click Save button");
        customerInfoPage.clickToSaveButton();

        log.info("Step 9: Verify save success");
        verifyEquals(customerInfoPage.getDynamicAttribueTextboxValue(driver, AbstractPageUIs.FIRSTNAME_ID, "value"), "Tony");

        verifyEquals(customerInfoPage.getDynamicAttribueTextboxValue(driver, AbstractPageUIs.LASTNAME_ID, "value"), "Luca");
        verifyEquals(customerInfoPage.getDynamicAttribueTextboxValue(driver, AbstractPageUIs.EMAIL_ID, "value"), emailEdit);
        verifyEquals(customerInfoPage.getDynamicAttribueTextboxValue(driver, AbstractPageUIs.COMPANY_ID, "value"), "AutoCompany");

        verifyEquals(customerInfoPage.getTextDOBDropdown(driver, "DateOfBirthDay"), "17");
        verifyEquals(customerInfoPage.getTextDOBDropdown(driver, "DateOfBirthMonth"), "November");
        verifyEquals(customerInfoPage.getTextDOBDropdown(driver, "DateOfBirthYear"), "1994");

        verifyEquals(customerInfoPage.isGenderSelected(driver, "gender-male"), true);
    }

    @Test
    public void TC02_AddAddress() {
        log.info("Step 1: Click Address menu");
        addressPage = customerInfoPage.clickAddressMenuBar();
        log.info("Step 2: Click Address button");
        addressPage.clickIntoDynamicButton(driver, "button-1 add-address-button");

        log.info("Step 3: Input valid data");
        addressPage.inputIntoDynamicTextbox(driver, "Address_FirstName", Address_FirstName);
        addressPage.inputIntoDynamicTextbox(driver, "Address_LastName", Address_LastName);
        addressPage.inputIntoDynamicTextbox(driver, "Address_Email", Address_Email);
        addressPage.inputIntoDynamicTextbox(driver, "Address_Company", Address_Company);
        addressPage.inputIntoDynamicTextbox(driver, "Address_City", Address_City);
        addressPage.inputIntoDynamicTextbox(driver, "Address_Address1", Address_Address1);
        addressPage.inputIntoDynamicTextbox(driver, "Address_Address2", Address_Address2);
        addressPage.inputIntoDynamicTextbox(driver, "Address_ZipPostalCode", Address_ZipPostalCode);
        addressPage.inputIntoDynamicTextbox(driver, "Address_PhoneNumber", Address_PhoneNumber);
        addressPage.inputIntoDynamicTextbox(driver, "Address_FaxNumber", Address_FaxNumber);
        addressPage.selectDynamicDropDown(driver, "Address.CountryId", Address_CountryId);

        log.info("Step 4: Click Save btn");
        addressPage.clickIntoDynamicButton(driver, "button-1 save-address-button");

        log.info("Step 5: Verify data");
        verifyEquals(addressPage.getDynamicTextWithTableLi("name"), Address_FirstName + " " + Address_LastName);
        verifyEquals(addressPage.getDynamicTextWithTableLi("email"), "Email: " + Address_Email);
        verifyEquals(addressPage.getDynamicTextWithTableLi("phone"), "Phone number: " + Address_PhoneNumber);
        verifyEquals(addressPage.getDynamicTextWithTableLi("fax"), "Fax number: " + Address_FaxNumber);
        verifyEquals(addressPage.getDynamicTextWithTableLi("company"), Address_Company);
        verifyEquals(addressPage.getDynamicTextWithTableLi("address1"), Address_Address1);
        verifyEquals(addressPage.getDynamicTextWithTableLi("address2"), Address_Address2);
        verifyEquals(addressPage.getDynamicTextWithTableLi("city-state-zip"), Address_City + ", " + Address_ZipPostalCode);
        verifyEquals(addressPage.getDynamicTextWithTableLi("country"), Address_CountryId);
    }

    @Test
    public void TC03_ChangePassword() {
        log.info("Step 1: Click Change Password menu ");
        changePasswordPage = addressPage.clickChangePasswordMenuBar();

        log.info("Step 2: Input valid password for change ");
        changePasswordPage.inputIntoDynamicTextbox(driver, "OldPassword", password);
        changePasswordPage.inputIntoDynamicTextbox(driver, "NewPassword", newPassword);
        changePasswordPage.inputIntoDynamicTextbox(driver, "ConfirmNewPassword", newPassword);

        log.info("Step 3: Click Change Password Button ");
        changePasswordPage.clickIntoDynamicButton(driver, "button-1 change-password-button");

        log.info("Step 4: Click Logout item ");
        mainPage = changePasswordPage.clickIntoLogOutButton();

        log.info("Step 5: Click Login item ");
        loginPage = mainPage.clickLoginItem();

        log.info("Step 6: Input valid email with new Password ");
        loginPage.inputIntoDynamicTextbox(driver, "Email", email);
        loginPage.inputIntoDynamicTextbox(driver, "Password", newPassword);

        log.info("Step 7: Click Login button");
        homePage = loginPage.clickToLoginButton();

        log.info("Step 8: Verify login with new Password success ");
        verifyTrue(homePage.isMyAccountItemDisplayed());

    }

    @Test
    public void TC04_MyProductReview() {
        log.info("Step 1: Click Logout item ");
        myAccountPage = homePage.clickToMyAccountItem();
        myProductReviewPage = myAccountPage.clickMyProductReviewsMenuBar();
        log.info("Step 2: Hover into Menutop");
        myAccountPage.hoverIntoMenuTopProduct("Computers");
        log.info("Step 3: Click into Menutop");
        myAccountPage.clickIntoMenuTopProduct("Desktops");
        log.info("Step 4: Click Addto Card");
        myAccountPage.clickAddToCardProduct("Build your own computer");
        log.info("Step 5: Click Add review");
        myAccountPage.clickAddYourReviewItem();
        log.info("Step 6: Input title review");
        myAccountPage.inputIntoDynamicTextbox(driver, "AddProductReview_Title", "review 1");
        log.info("Step 7: Input content review");
        myAccountPage.inputIntoDynamicTextArea(driver, "AddProductReview_ReviewText", "ok review");
        log.info("Step 8: Click Review button");
        myAccountPage.clickIntoDynamicButton(driver, "button-1 write-product-review-button");
        log.info("Step 9: Click Logo Nop");
        homePage = myAccountPage.clickLogoNopCommerce();

        log.info("Step 10: Click My Account item");
        myAccountPage = homePage.clickToMyAccountItem();
        log.info("Step 11: Click My product review");
        myProductReviewPage = myAccountPage.clickMyProductReviewsMenuBar();
        log.info("Step 12: Verify name displays");
        myProductReviewPage.isNameProductReviewDisplayed("Build your own computer");


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

    String Address_FirstName = "Automation";
    String Address_LastName = "FC";
    String Address_Email = "nhanpv1994@gmail.com";
    String Address_Company = "Loote";
    String Address_City = "Da Nang";
    String Address_Address1 = "Dia chi 1";
    String Address_Address2 = "Dia chi 2";
    String Address_ZipPostalCode = "55000";
    String Address_PhoneNumber = "0935602450";
    String Address_FaxNumber = "0987654321";
    String Address_CountryId = "Viet Nam";
    String Address_StateProvinceId = "Other";


}
