package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUIs;

public class AddressPageObject extends AbstractPage {
    WebDriver driver;
    public AddressPageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }
    public String getDynamicTextWithTableLi(String inforName){
        waitForElementVisible(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
        return getTextElement(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
    }

}
