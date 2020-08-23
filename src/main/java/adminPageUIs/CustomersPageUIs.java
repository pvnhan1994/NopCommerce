package adminPageUIs;

public class CustomersPageUIs {
    public static final String ADD_NEW_BUTTON = "//a[@class='btn bg-blue']";
    public static final String ROLE_DROPDOWN = "//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div/div/div";
    public static final String LISTITEM_IN_ROLE_DROPDOWN = "//ul[@id='SelectedCustomerRoleIds_listbox']//li";
    public static final String CLEAR_ITEM_IN_ROLE_DROPDOWN = "//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div//span[@title='clear']";
    public static final String SAVE_CONTINUTE_BUTTON = "//button[@name='save-continue']";

    public static final String TOAST_MSG_ADD_SUCCESS = "//div[@class='alert alert-success alert-dismissable']";
    public static final String GENDER_RADIO = "//label[text()='Gender']/parent::div/parent::div/parent::div/div//input[@id='%s']";
    public static final String ITEM_SELECTED_DROPDOWN = "//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[1]";
    public static final String ROLE_SELECTED = "//li[starts-with(@class,'k-button')]/span[text()='%s']";

    public static final String MAPPING_KEYWORD_IN_TABLE = "//table[@id='customers-grid']/tbody//td[contains(text(),'%s')]";
}
