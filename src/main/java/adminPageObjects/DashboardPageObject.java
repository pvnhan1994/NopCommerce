package adminPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends AbstractPage {
    WebDriver driver;

    public DashboardPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }
}
