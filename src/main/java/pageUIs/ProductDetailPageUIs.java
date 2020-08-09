package pageUIs;

public class ProductDetailPageUIs {
    public static final String SKU_DETAIL_PRODUCT = "//span[@id='sku-3']";
    public static final String NAME_DETAIL_PRODUCT = "//div[@class='product-name']";

    public static final String RADIO_BUTTON_CHECKBOX_CONFIG = "//dt/label[text()=' %s ']/following::dd[1]//label[contains(text(),'%s')]";
    public static final String DROPDOWN_LIST_CONFIG = "//dt/label[text()=' %s ']/following::dd[1]/select";

    public static final String TOTAL_PRICE = "//span[@id='price-value-1']";
    public static final String QUANTITY_PRODUCT = "//input[@id='product_enteredQuantity_1']";

   // ==========================
    public static final String CHECKBOX = "//dt/label[text()=' %s ']/following::dd[1]//label[contains(text(),'%s')]//preceding-sibling::input";
}
