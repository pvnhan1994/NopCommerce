package customerPageUIs;

public class CheckOutPagetUIs {
    public static final String CHECK_OUT_BUTTON = "//button[@id='checkout']";
    public static final String TEXT_IN_HEADER = "//h1[contains(text(),'Checkout')]";
    public static final String DYNAMIC_STEP_PAGE_TO_CHECKOUT = "//li//h2[text()='%s']";
    public static final String DYNAMIC_CONTINUTE_BUTTON = "//li//h2[text()='%s']//parent::div//following-sibling::div//div[@class='buttons']//input";

    public static final String BODY_PAYMENT_INFOR = "//div[@class='info']";

    public static final String PAGE_ORDER_SUCCESS = "//div[@class='page checkout-page order-completed-page']";
    public static final String ORDER_NUMBER = "//div[@class='order-number']//strong";


}
