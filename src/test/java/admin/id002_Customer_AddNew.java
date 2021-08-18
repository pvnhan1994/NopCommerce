package admin;

import adminPageObjects.CustomersPageObject;
import adminPageObjects.DashboardPageObject;
import adminPageObjects.LoginPageObject;
import commons.AbstractPageUIs;
import commons.AbstractTest;
import commons.AdminPageGeneratorManager;
import commons.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class id002_Customer_AddNew extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    CustomersPageObject customersPage;
    private String email = Constants.EMAIL;
    private String password = Constants.PASSWORD;
    private String firstName = Constants.FIRST_NAME;
    private String lastName = Constants.LAST_NAME;
    private String DoB = "11/11/2000";
    private String company = "JSC Company";
    private String adminComment = "Commit something description";
    private String role1 = "Registered";

    private String editEmail = "Edit" + email;
    private String editFirstName = "Edit" + firstName;
    private String editLastName = "Edit" + lastName;
    private String editCompany = "Edit" + company;

    private String Address_FirstName = "Automation";
    private String Address_LastName = "FC";
    private String Address_Email = "nhanpv1994@gmail.com";
    private String Address_Company = "Loote";
    private String Address_City = "Da Nang";
    private String Address_Address1 = "Dia chi 1";
    private String Address_Address2 = "Dia chi 2";
    private String Address_ZipPostalCode = "55000";
    private String Address_PhoneNumber = "0935602450";
    private String Address_FaxNumber = "0987654321";
    private String Address_CountryId = "Viet Nam";

    private String Edit_Address_FirstName = "EditAutomation";
    private String Edit_Address_LastName = "EditFC";
    private String Edit_Address_Email = "Editnhanpv1994@gmail.com";
    private String Edit_Address_Company = "EditLoote";
    private String Edit_Address_City = "EditDa Nang";
    private String Edit_Address_Address1 = "EditDia chi 1";
    private String Edit_Address_Address2 = "EditDia chi 2";
    private String Edit_Address_ZipPostalCode = "55000";
    private String Edit_Address_PhoneNumber = "0935602450";
    private String Edit_Address_FaxNumber = "0987654321";
    private String Edit_Address_CountryId = "Viet Nam";
    public static final Log log1 = LogFactory.getLog(id002_Customer_AddNew.class);

    public id002_Customer_AddNew(){

    }
    //    @Parameters("browser")
    //    @BeforeClass
    //    public void beforeClass(String browser) {
    //        driver = openMultiBrowser(browser);
    //        loginPage = AdminPageGeneratorManager.getLoginPage(driver);
    //        loginPage.inputIntoDynamicTextbox(driver, "Email", Constants.EMAIL_PAGEADMIN);
    //        loginPage.inputIntoDynamicTextbox(driver, "Password", Constants.PASSWORD_PAGEADMIN);
    //        dashboardPage = loginPage.clickIntoLoginButton();
    //
    //        log.info("Step 1: Click Customer menu");
    //        dashboardPage.clickIntoDynamicMenuBarMini(driver, "Customers");
    //
    //    }
    //
    //    @BeforeMethod
    //    public void beforeMethod() {
    //        log.info("Step 2: Click Products menu");
    //        customersPage = (CustomersPageObject) dashboardPage.openMultiPageInItemSubMenuBarMini(driver, "Customers");
    //        log.info("Step : Check expand/collapse Search component");
    //        customersPage.clickIntoIconExpandCollapseComponent();
    //    }
    //
    //    @Test
    //    public void TC007_CreateNewCustomer() throws Exception {
    //        log.info("Step 3: Click Into Add New Button");
    //        customersPage.clickIntoAddNewButton();
    //        log.info("Step 4: Input valid data into all the fields");
    //        customersPage.inputIntoDynamicTextbox(driver, "Email", email);
    //        customersPage.inputIntoDynamicTextbox(driver, "Password", password);
    //        customersPage.inputIntoDynamicTextbox(driver, "FirstName", firstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "LastName", lastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "DateOfBirth", DoB);
    //        customersPage.inputIntoDynamicTextbox(driver, "Company", company);
    //        customersPage.inputIntoDynamicTextArea(driver, "AdminComment", adminComment);
    //        customersPage.selectDynamicRadioCheckboxWithID(driver, "Gender_Male");
    //        customersPage.selectDynamicCheckbox(driver, "Active");
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //
    //        log.info("Step 5: Click Save Continute button ");
    //        customersPage.clickIntoSaveContinuteButton();
    //
    //        log.info("Step 6: Verify toast msg displayed");
    //        verifyEquals("The new customer has been added successfully.", customersPage.getToastMsgSuccess());
    //
    //        log.info("Step 7: Verify infor displays correct");
    //        verifyEquals(email, customersPage.getAttributeInTextbox(driver, "Email", "value"));
    //        verifyEquals(firstName, customersPage.getAttributeInTextbox(driver, "FirstName", "value"));
    //        verifyEquals(lastName, customersPage.getAttributeInTextbox(driver, "LastName", "value"));
    //        verifyEquals(DoB, customersPage.getAttributeInTextbox(driver, "DateOfBirth", "value"));
    //        verifyEquals(company, customersPage.getAttributeInTextbox(driver, "Company", "value"));
    //        verifyTrue(customersPage.isGenderSelected("Gender_Male"));
    //        verifyEquals(role1, customersPage.getTextRoleInRoleCustomerDropDown(role1));
    //
    //
    //    }
    //
    //    @Test
    //    public void TC008_SearchCustomerWithEmail() {
    //
    //        log.info("Step 3: Input data into Email textbox");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", email);
    //
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 5: Verify 1 customer displays in table");
    //        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    //    }
    //
    //    @Test
    //    public void TC009_SearchWithFirstNameAndLastName() throws Exception {
    //
    //        log.info("Step 3: Input data into First Name And Last Name");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", firstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", lastName);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 5: Verify 1 customer displays in table");
    //        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    //
    //    }
    //
    //    @Test
    //    public void TC010_SearchWithRolesAndCompany() throws Exception {
    //        log.info("Step 3: Input data into Roles And Company");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", company);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //        log.info("Step 5: Verify 1 customer displays in table");
    //        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    //
    //    }
    //
    //    @Test
    //    public void TC011_SearchWithFullData() throws Exception {
    //        log.info("Step 3: Input data into all the fields");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", email);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", firstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", lastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", company);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 5: Verify 1 customer displays in table");
    //        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    //
    //    }
    //
    //    @Test
    //    public void TC012_EditCustomer() throws Exception {
    //        log.info("Step 3: Input data into all the fields");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", email);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", firstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", lastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", company);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click into Edit Button");
    //        customersPage.clickIntoEditButton(email);
    //
    //        log.info("Step 5: Input data into Edit Fields ");
    //        customersPage.inputIntoDynamicTextbox(driver, "Email", editEmail);
    //        customersPage.inputIntoDynamicTextbox(driver, "FirstName", editFirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "LastName", editLastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "Company", editCompany);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 6: Click save button ");
    //        customersPage.clickIntoSaveButton();
    //
    //        log.info("Step 7: Input data into Search Fields ");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", editEmail);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", editFirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", editLastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", editCompany);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 6: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 7: Verify 1 customer displays in table");
    //        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    //
    //    }
    //
    //    @Test
    //    public void TC013_AddNewAddressinCustomerDetail() throws Exception {
    //        log.info("Step 3: Input data into Search Fields ");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", editEmail);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", editFirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", editLastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", editCompany);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 5: Click into Edit Button");
    //        customersPage.clickIntoEditButton(editEmail);
    //
    //        log.info("Step 6: Click into Address Container");
    //        customersPage.clickIntoAddressContainer();
    //
    //        log.info("Step 7: Click into Add New Address Container");
    //        customersPage.clickIntoAddNewAddress();
    //
    //        log.info("Step 8: Input data into all the fields Address");
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_FirstName", Address_FirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_LastName", Address_LastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Email", Address_Email);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Company", Address_Company);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_City", Address_City);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Address1", Address_Address1);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Address2", Address_Address2);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_ZipPostalCode", Address_ZipPostalCode);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_PhoneNumber", Address_PhoneNumber);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_FaxNumber", Address_FaxNumber);
    //        customersPage.selectDynamicDropDown(driver, "Address.CountryId", Address_CountryId);
    //        customersPage.selectStateProvince("Other");
    //
    //        log.info("Step 9: Click to Save Address Button");
    //        customersPage.clickIntoSaveAddressButton();
    //
    //        log.info("Step 10: Verify toast msg displayed");
    //        verifyEquals("The new address has been added successfully.", customersPage.getToastMsgSuccess());
    //
    //        log.info("Step 11: Click into Back To Customer Detail");
    //        customersPage.clickIntoItemBackToCustomerDetail();
    //    }
    //
    //    @Test
    //    public void TC014_EditCustomerinCustomerDetail() throws Exception {
    //        log.info("Step 3: Input data into Search Fields ");
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", editEmail);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", editFirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", editLastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", editCompany);
    //        customersPage.clearRole();
    //        customersPage.selectRoleCustomer(role1);
    //
    //        log.info("Step 4: Click Search button");
    //        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
    //
    //        log.info("Step 5: Click into Edit Button");
    //        customersPage.clickIntoEditButton(editEmail);
    //
    //        log.info("Step 6: Click into Address Container");
    //        customersPage.clickIntoAddressContainer();
    //
    //        log.info("Step 7: Click into Edit Address with name editEmail");
    //        customersPage.clickIntoEditAddressButton(editEmail);
    //
    //        log.info("Step 8: Input data into all the fields Address");
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_FirstName", Edit_Address_FirstName);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_LastName", Edit_Address_LastName);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Email", Edit_Address_Email);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Company", Edit_Address_Company);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_City", Edit_Address_City);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Address1", Edit_Address_Address1);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_Address2", Edit_Address_Address2);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_ZipPostalCode", Edit_Address_ZipPostalCode);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_PhoneNumber", Edit_Address_PhoneNumber);
    //        customersPage.inputIntoDynamicTextbox(driver, "Address_FaxNumber", Edit_Address_FaxNumber);
    //        customersPage.selectDynamicDropDown(driver, "Address.CountryId", Edit_Address_CountryId);
    //        customersPage.selectStateProvince("Other");
    //
    //        log.info("Step 9: Click to Save Address Button");
    //        customersPage.clickIntoSaveAddressButton();
    //
    //        log.info("Step 10: Verify toast msg displayed");
    //        verifyEquals("The address has been updated successfully.", customersPage.getToastMsgSuccess());
    //
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_FirstName", "value"), Edit_Address_FirstName);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_LastName", "value"), Edit_Address_LastName);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_Email", "value"), Edit_Address_Email);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_Company", "value"), Edit_Address_Company);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_City", "value"), Edit_Address_City);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_Address1", "value"), Edit_Address_Address1);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_Address2", "value"), Edit_Address_Address2);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_PhoneNumber", "value"), Edit_Address_ZipPostalCode);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_FaxNumber", "value"), Edit_Address_PhoneNumber);
    //        verifyEquals(customersPage.getDynamicAttribueTextboxValue(driver, "Address_FaxNumber", "value"), Edit_Address_FaxNumber);
    //        verifyEquals(customersPage.getFirstValueSelectedInDropDown(driver, "Address_CountryId"), Edit_Address_CountryId);
    //        verifyEquals(customersPage.getFirstValueSelectedInDropDown(driver, "Address_StateProvinceId"), "Other");
    //
    //        log.info("Step 11: Click into Back To Customer Detail");
    //        customersPage.clickIntoItemBackToCustomerDetail();
    //
    //        log.info("Step 12: Verify infor Updated Address in Table Grid");
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "1"), Edit_Address_FirstName);
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "2"), Edit_Address_LastName);
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "3"), Edit_Address_Email);
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "4"), Edit_Address_PhoneNumber);
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "5"), Edit_Address_FaxNumber);
    //        verifyEquals(customersPage.getDynamicTextInTableGridByIndex(driver, "6"),
    //                Edit_Address_Company +"\n"+
    //                        Edit_Address_Address1 +"\n"+
    //                        Edit_Address_Address2 +"\n"+
    //                        Edit_Address_City+","+Edit_Address_ZipPostalCode + "\n"+
    //                        Edit_Address_CountryId);
    //
    //    }
    @Test
    public void test(){
        log1.info("dshjlhka");

    }
//    @AfterClass(alwaysRun = true)
//    public void afterClass() {
//        closeBrowserAndDriver(driver);
//
//    }
}
