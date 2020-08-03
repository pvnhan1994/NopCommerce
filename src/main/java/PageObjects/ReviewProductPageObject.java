package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ReviewProductPageObject extends AbstractPage {
    WebDriver driver;
    public ReviewProductPageObject (WebDriver mappingDriver){
        driver = mappingDriver;
    }
}
