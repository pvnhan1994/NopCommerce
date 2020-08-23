package commons;

public class AbstractPageUIs {

    //Customer
    public static final String DYNAMIC_ITEM_ON_HEADER = "//a[@class='%s']";
    public static final String DYNAMIC_TEXTBOX_WITH_ID = "//input[@id='%s']";
    public static final String DYNAMIC_BUTTON_WITH_CLASS = "//input[@class='%s']";
    public static final String DYNAMIC_BUTTON_WITH_ID = "//button[@id='%s']";
    public static final String DYNAMIC_VALIDATE_WITH_ID = "//span[@id='%s']";
    public static final String DYNAMIC_RADIO_CHECKBOX_WITH_ID = "//input[@id='%s']";
    public static final String DYNAMIC_RADIO_CHECKBOX_WITH_NAME = "//input[@name='%s']";
    public static final String EMAIL_ID ="Email";
    public static final String COMPANY_ID ="Company";
    public static final String FIRSTNAME_ID = "FirstName";
    public static final String LASTNAME_ID = "LastName";
    public static final String DYNAMIC_MENU_LEFT_BAR = "//a[contains(text(),'%s')]";
    public static final String DYNAMIC_TEXTAREA = "//textarea[@id='%s']" ;
    public static final String DYNAMIC_ITEM_FOOTER_PAGE = "//ul[@class='list']//a[text()='%s']";
    public static final String DYNAMIC_TOAST_MSG = "//p[@class='content']";
    public static final String LOGO_NOP = "//div[@class='header-logo']//a//img";
    public static final String DYNAMIC_NUMER_PRODUCT_ON_ITEM_HEADER = "//span[@class='%s']";
    public static final String SHOPPING_CART_ITEM_HEADER = "//li[@id='topcartlink']";
    public static final String COUNT_PRODUCT_ADD_SHOPPING_CART_ITEM_HEADER = "//a[contains(text(),'%s')]";
    public static final String ATTRIBUTE_PRODUCT_SHOPPING_CART_ITEM_HEADER = "//div[@class='product']/div[@class='attributes']";
    public static final String UNIT_PRICE_SHOPPING_CART_ITEM_HEADER = "//div[@class='price']";
    public static final String QUANTITY_PRODUCT_SHOPPING_CART_ITEM_HEADER = "//div[@class='quantity']";
    public static final String CLOSE_TOAST_MSG = "//span[@class='close']";
    public static final String DYNAMIC_MENU_TOP_PRODDUCT = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_INFOR_TABLE_DATA = "//td[@class='%s']//%s";
    public static final String DYNAMIC_INFOR_CART_FOOTER = "//label[contains(text(),'%s')]//parent::td//following-sibling::td";
    public static final String DYNAMIC_CONFIRM_ORDER = "//strong[text()='%s']//parent::div//following-sibling::ul//li[@class='%s']";

    public static final String DYNAMIC_SELECT_DROPDOWN = "//select[@name='%s']";

    public static final String DYNAMIC_SELECT_DROPDOWN_ID = "//select[@id='%s']";
    public static final String DYNAMIC_CHECKBOX = "//input[@id='%s']" ;
    public static final String DYNAMIC_CHECKBOX_WITH_LABEL = "//label[text()='%s']//preceding-sibling::input";


    //Admin
    public static final String DYNAMIC_SLIDE_MENUBAR_MINI = "//li[@class='treeview']/a/span[text()='%s']";
    public static final String DYNAMIC_SUB_MENUBAR_MINI = "//ul[@class='sidebar-menu tree']//ul//span[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_ADMIN = "//label[text()='%s']/parent::div/parent::div/parent::div/div//input";
    public static final String DYNAMIC_RADIO_ADMIN = "//label[text()='%s']/parent::div/parent::div/parent::div/div//input[@id='%s']";
}
