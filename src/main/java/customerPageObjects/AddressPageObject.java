package customerPageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import customerPageUIs.AddressPageUIs;

public class AddressPageObject extends AbstractPage {
    WebDriver driver;
    public AddressPageObject(WebDriver mappingDriver){
        driver = mappingDriver;
    }
    public String getDynamicTextWithTableLi(String inforName){
        waitForElementVisible(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
        return getTextElement(driver, AddressPageUIs.DYNAMIC_INFOR_ADDRESS,inforName);
    }

    public void selectStateProvince(String value) {
        waitForElementInvisible(driver, AddressPageUIs.LOADING_STATE_PROVINCE);
        waitForElementVisible(driver, AddressPageUIs.STATE_PROVINCE);
        selectItemInDropDown(driver,AddressPageUIs.STATE_PROVINCE,value);
    }
}
