package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class WishListPageObject extends AbstractPage {
    WebDriver driver;

    public WishListPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

}
