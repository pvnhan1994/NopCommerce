package pageUIs;

public class MyAccountPageUIs {
    public static final String CHANGE_PASSWORD_MENU_BAR = "//a[contains(text(),'Change password')]";
    public static final String ADDRESS_MENU_BAR = "//a[contains(text(),'Addresses')]";
    public static final String CUSTOMER_INFO_MENU_BAR = "//a[contains(text(),'Customer info')]";
    public static final String MY_PRODUCT_REVIEWS_MENU_BAR = "//a[contains(text(),'My product reviews')]";
    public static final String DYNAMIC_MENU_TOP_PRODDUCT = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS = "//h2[@class='product-title']//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']" +
            "/div[@class='buttons']/input[@class='button-2 product-box-add-to-cart-button']";
    public static final String ADD_YOUR_REVIEW_ITEM = "//a[text()='Add your review']";
    public static final String LOGO_NOP = "//div[@class='header-logo']//a//img";
}