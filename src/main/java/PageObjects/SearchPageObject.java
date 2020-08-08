package PageObjects;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPageUIs;

public class SearchPageObject extends AbstractPage {
    WebDriver driver;

    public SearchPageObject(WebDriver mappingDriver) {
        driver = mappingDriver;
    }

    public String getValidateMessageSearch(String classValidate) {
        waitForElementVisible(driver, SearchPageUIs.VALIDATE_MSG, classValidate);
        return getTextElement(driver, SearchPageUIs.VALIDATE_MSG, classValidate);
    }

    public int countProductRelativeInSearch(String nameProductRelative) {
        return listSizeLocatorInElements(driver, SearchPageUIs.DYNAMIC_NAME_PRODUCT_RELATIVE, nameProductRelative);
    }

    public void input(String value) {
        waitForElementVisible(driver, SearchPageUIs.INPUT);
        sendkeyToElementByJS(driver, SearchPageUIs.INPUT, value);
    }
}
