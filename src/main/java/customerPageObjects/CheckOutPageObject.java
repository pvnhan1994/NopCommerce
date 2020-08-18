package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.CheckOutPagetUIs;

public class CheckOutPageObject extends AbstractPage {
    WebDriver driver;

    public CheckOutPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isMessageInHeaderDisplayed() {
        waitForElementVisible(driver, CheckOutPagetUIs.TEXT_IN_HEADER);
        return isControlDisplayed(driver, CheckOutPagetUIs.TEXT_IN_HEADER);
    }

    public boolean isDynamicStepToCheckOutPageDisplayed(String nameStepPageToCheckOut) {
        waitForElementVisible(driver, CheckOutPagetUIs.DYNAMIC_STEP_PAGE_TO_CHECKOUT, nameStepPageToCheckOut);
        return isControlDisplayed(driver, CheckOutPagetUIs.DYNAMIC_STEP_PAGE_TO_CHECKOUT, nameStepPageToCheckOut);
    }

    public void clickIntoDynamicContinuteButton(String nameStepPageToCheckOut) {
        waitForElementVisible(driver, CheckOutPagetUIs.DYNAMIC_CONTINUTE_BUTTON, nameStepPageToCheckOut);
        clickToElement(driver, CheckOutPagetUIs.DYNAMIC_CONTINUTE_BUTTON, nameStepPageToCheckOut);
    }

    public boolean isBodyPaymentInformationDisplayed() {
        waitForElementVisible(driver, CheckOutPagetUIs.BODY_PAYMENT_INFOR);
        return isControlDisplayed(driver, CheckOutPagetUIs.BODY_PAYMENT_INFOR);
    }



    public boolean isOrderPageSuccessDisplayed() {
        waitForElementVisible(driver, CheckOutPagetUIs.PAGE_ORDER_SUCCESS);
        return isControlDisplayed(driver, CheckOutPagetUIs.PAGE_ORDER_SUCCESS);
    }

    public String getOrderNumber() {
        waitForElementVisible(driver, CheckOutPagetUIs.ORDER_NUMBER);
        return getTextElement(driver, CheckOutPagetUIs.ORDER_NUMBER);
    }
}
