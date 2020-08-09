package pageUIs;

public class MyAccountPageUIs {
    public static final String DYNAMIC_MENU_TOP_PRODDUCT = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_ADD_TO_CART_PRODUCT_DETAILS = "//h2[@class='product-title']//a[text()='%s']";
    public static final String ADD_YOUR_REVIEW_ITEM = "//a[text()='Add your review']";



    public static final String DYNAMIC_OPTION_BUTTON_PRODUCT_DETAIL = "//h2[@class='product-title']//a[text()='%s']" +
            "//parent::h2//following-sibling::div[@class='add-info']//div[@class='buttons']/input[%s]";
    public static final String PRICE_PRODUCT = "//h2[@class='product-title']//a[text()='%s']//parent::h2//following-sibling::div[@class='add-info']//div[@class='prices']";
}
