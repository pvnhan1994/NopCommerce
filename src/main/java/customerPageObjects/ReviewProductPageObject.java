package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.ReviewProductPageUIs;

public class ReviewProductPageObject extends AbstractPage {
    WebDriver driver;
    public ReviewProductPageObject (WebDriver mappingDriver){
        driver = mappingDriver;
    }

    public boolean isProductDisplayed(String nameProduct) {
        waitForElementVisible(driver, ReviewProductPageUIs.NAME_REVIEW_PRODUCT, nameProduct);
        return isControlDisplayed(driver, ReviewProductPageUIs.NAME_REVIEW_PRODUCT, nameProduct);
    }
    public boolean isProductUndisplayed(String nameProdcut){
        waitForElementVisible(driver, ReviewProductPageUIs.NAME_REVIEW_PRODUCT, nameProdcut);
        return isControlUndisplayed(driver, ReviewProductPageUIs.NAME_REVIEW_PRODUCT, nameProdcut);
    }
}
