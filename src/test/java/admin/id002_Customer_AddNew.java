package admin;

import adminPageObjects.CustomersPageObject;
import adminPageObjects.DashboardPageObject;
import adminPageObjects.LoginPageObject;
import commons.AbstractTest;
import commons.AdminPageGeneratorManager;
import commons.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class id002_Customer_AddNew extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPage;
    DashboardPageObject dashboardPage;
    CustomersPageObject customersPage;
    String email = Constants.EMAIL;
    String password = Constants.PASSWORD;
    String firstName = Constants.FIRST_NAME;
    String lastName = Constants.LAST_NAME;
    String DoB = "11/11/2000";
    String company = "JSC Company";
    String adminComment = "Commit something description";
    String role1 = "Registered";

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browser) {
        driver = openMultiBrowser(browser);
        loginPage = AdminPageGeneratorManager.getLoginPage(driver);
        loginPage.inputIntoDynamicTextbox(driver, "Email", Constants.EMAIL_PAGEADMIN);
        loginPage.inputIntoDynamicTextbox(driver, "Password", Constants.PASSWORD_PAGEADMIN);
        dashboardPage = loginPage.clickIntoLoginButton();

        log.info("Step 1: Click Customer menu");
        dashboardPage.clickIntoDynamicMenuBarMini(driver, "Customers");

    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Step 2: Click Products menu");
        customersPage = (CustomersPageObject) dashboardPage.openMultiPageInItemSubMenuBarMini(driver, "Customers");
    }

    @Test
    public void TC007_CreateNewCustomer() throws Exception {
        log.info("Step 3: Click Into Add New Button");
        customersPage.clickIntoAddNewButton();
        log.info("Step 4: Input valid data into all the fields");
        customersPage.inputIntoDynamicTextbox(driver, "Email", email);
        customersPage.inputIntoDynamicTextbox(driver, "Password", password);
        customersPage.inputIntoDynamicTextbox(driver, "FirstName", firstName);
        customersPage.inputIntoDynamicTextbox(driver, "LastName", lastName);
        customersPage.inputIntoDynamicTextbox(driver, "DateOfBirth", DoB);
        customersPage.inputIntoDynamicTextbox(driver, "Company", company);
        customersPage.inputIntoDynamicTextArea(driver, "AdminComment", adminComment);
        customersPage.selectDynamicRadioCheckboxWithID(driver, "Gender_Male");
        customersPage.selectDynamicCheckbox(driver, "Active");
        customersPage.clearRole();
        customersPage.selectRoleCustomer(role1);


        log.info("Step 5: Click Save Continute button ");
        customersPage.clickIntoSaveContinuteButton();

        log.info("Step 6: Verify toast msg displayed");
        verifyEquals("The new customer has been added successfully.", customersPage.getToastMsgAddCustomerSuccess());

        log.info("Step 7: Verify infor displays correct");
        verifyEquals(email, customersPage.getAttributeInTextbox(driver, "Email", "value"));
        verifyEquals(firstName, customersPage.getAttributeInTextbox(driver, "FirstName", "value"));
        verifyEquals(lastName, customersPage.getAttributeInTextbox(driver, "LastName", "value"));
        verifyEquals(DoB, customersPage.getAttributeInTextbox(driver, "DateOfBirth", "value"));
        verifyEquals(company, customersPage.getAttributeInTextbox(driver, "Company", "value"));
        verifyTrue(customersPage.isGenderSelected("Gender_Male"));
        verifyEquals(role1, customersPage.getTextRoleInRoleCustomerDropDown(role1));


    }

    @Test
    public void TC008_SearchCustomerWithEmail() {

        log.info("Step 3: Input data into Email textbox");
        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", email);


        log.info("Step 4: Click Search button");
        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");

        log.info("Step 5: Verify 1 customer displays in table");
        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));
    }

    @Test
    public void TC009_SearchWithFirstNameAndLastName() throws Exception {

        log.info("Step 3: Input data into First Name And Last Name");
        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", firstName);
        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", lastName);
        customersPage.clearRole();
        customersPage.selectRoleCustomer(role1);

        log.info("Step 4: Click Search button");
        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");

        log.info("Step 5: Verify 1 customer displays in table");
        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));

    }

    @Test
    public void TC010_SearchWithRolesAndCompany() throws Exception {
        log.info("Step 3: Input data into Roles And Company");
        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", company);
        customersPage.clearRole();
        customersPage.selectRoleCustomer(role1);

        log.info("Step 4: Click Search button");
        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");
        log.info("Step 5: Verify 1 customer displays in table");
        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));

    }

    @Test
    public void TC011_SearchWithFullData() throws Exception {
        log.info("Step 3: Input data into all the fields");
        customersPage.inputIntoDynamicTextbox(driver, "SearchEmail", email);
        customersPage.inputIntoDynamicTextbox(driver, "SearchFirstName", firstName);
        customersPage.inputIntoDynamicTextbox(driver, "SearchLastName", lastName);
        customersPage.inputIntoDynamicTextbox(driver, "SearchCompany", company);
        customersPage.clearRole();
        customersPage.selectRoleCustomer(role1);

        log.info("Step 4: Click Search button");
        customersPage.clickIntoDynamicButtonWithID(driver, "search-customers");

        log.info("Step 5: Verify 1 customer displays in table");
        verifyEquals(1, customersPage.countMappingKeywordInTableResult(email));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);

    }
}
