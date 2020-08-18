package customerPageObjects;

import commons.AbstractPage;

import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends AbstractPage {
    WebDriver driver;
    public ChangePasswordPageObject(WebDriver mappingDriver){
        driver=mappingDriver;
    }


}
