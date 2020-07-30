package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.MyProductReviewUIs;

public class MyProductReviewsPageObject extends AbstractPage {
    WebDriver driver;

    public MyProductReviewsPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public boolean isNameProductReviewDisplayed(String nameProduct) {
        waitForElementVisible(driver, MyProductReviewUIs.NAME_PRODUCT_REVIEW, nameProduct);
        return isControlDisplayed(driver, MyProductReviewUIs.NAME_PRODUCT_REVIEW, nameProduct);

    }
}
