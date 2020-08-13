package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CheckOutPageObject extends AbstractPage {
    WebDriver driver;
    public CheckOutPageObject(WebDriver mappingDriver){
        driver = mappingDriver;

    }
}
