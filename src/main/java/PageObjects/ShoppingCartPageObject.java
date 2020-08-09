package PageObjects;

import commons.AbstractPage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.ShoppingCartPageUIs;

public class ShoppingCartPageObject extends AbstractPage {
    WebDriver driver;

    public ShoppingCartPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public ProductDetailPageObject clickEditItem() {
        waitForElementVisible(driver, ShoppingCartPageUIs.EDIT_ITEM);
        clickToElementByJS(driver, ShoppingCartPageUIs.EDIT_ITEM);
        return PageGeneratorManager.getProductDetail(driver);
    }
}
