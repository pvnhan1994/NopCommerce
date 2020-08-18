package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.OrderPageUIs;

public class OrderPageObject extends AbstractPage {
    WebDriver driver;
    public OrderPageObject(WebDriver mappingDriver){
        driver=mappingDriver;
    }

    public String getOrderNumber() {
        waitForElementVisible(driver, OrderPageUIs.ORDER_NUMBER);
        return getTextElement(driver,OrderPageUIs.ORDER_NUMBER).toUpperCase();
    }


    public void clickDetailItem() {
        waitForElementVisible(driver, OrderPageUIs.DETAIL_ITEM);
        clickToElement(driver, OrderPageUIs.DETAIL_ITEM);
    }

    public String getOrderDay() {
        waitForElementVisible(driver, OrderPageUIs.ORDER_DATE);
        return getTextElement(driver, OrderPageUIs.ORDER_DATE);
    }
}
