package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CompareProductListPageObject extends AbstractPage {
    WebDriver driver;

    public CompareProductListPageObject (WebDriver mappingDriver){
        driver = mappingDriver;
    }
}
