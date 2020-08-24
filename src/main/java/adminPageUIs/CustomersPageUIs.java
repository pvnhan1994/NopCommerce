package adminPageUIs;

public class CustomersPageUIs {
    public static final String ADD_NEW_BUTTON = "//a[@class='btn bg-blue']";
    public static final String ROLE_DROPDOWN = "//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div/div/div";
    public static final String LISTITEM_IN_ROLE_DROPDOWN = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String CLEAR_ITEM_IN_ROLE_DROPDOWN = "//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div//span[@title='clear']";
    public static final String SAVE_CONTINUTE_BUTTON = "//button[@name='save-continue']";

    public static final String TOAST_MSG_ADD_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";
    public static final String GENDER_RADIO = "//label[text()='Gender']/parent::div/parent::div/parent::div/div//input[@id='%s']";
    public static final String ROLE_SELECTED = "//li[starts-with(@class,'k-button')]/span[text()='%s']";

    public static final String MAPPING_KEYWORD_IN_TABLE = "//table[@id='customers-grid']/tbody//td[contains(text(),'%s')]";
    public static final String EDIT_BUTTON = "//td[text()='%s']/parent::tr//a";
    public static final String SAVE_BUTTON = "//button[@name='save']";

    public static final String ADDRESS_CONTAINER = "//span[contains(text(),'Addresses')]";
    public static final String ADD_NEW_ADDRESS_BUTTON = "//button[contains(text(),'Add new address')]";
    public static final String LOADING_STATE_PROVINCE = "//span[@id='states-loading-progress']";
    public static final String STATE_PROVINCE = "//select[@name='Address.StateProvinceId']";
    public static final String SAVE_ADDRESS_BUTTON = "//div[@class='pull-right']//button";
    public static final String BACK_TO_CUSTOMER_DETAIL_BUTTON = "//a[contains(text(),'back to customer details')]";
    public static final String EDIT_ADDRESS_BUTTON = "//td[text()='%s']//following-sibling::td/a[text()='Edit']";
    public static final String VALUE_TABLE_GRID = "//table[@id='customer-addresses-grid']//td[%s]";
}
