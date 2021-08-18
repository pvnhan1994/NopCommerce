package commons;

import adminPageUIs.DynamicAdminPageUIs;
import customerPageObjects.HomePageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import customerPageUIs.WishListPageUIs;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class AbstractPage {

    public void openUrl(WebDriver driver, String urlValue) {
        driver.get(urlValue);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshToPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void fowardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendkeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        element.click();
    }


    public void sendkeyElements(WebDriver driver, String locator, String sendKeysValue, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        element.clear();
        element.sendKeys(sendKeysValue);
    }

    public void enterOnKeyboard(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        element.sendKeys(Keys.ENTER);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String itemText) {
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByVisibleText(itemText);
    }

    public void selectItemInDropDown(WebDriver driver, String locator, String itemText, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByVisibleText(itemText);
    }

    public String getFirstSelectedDropdown(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String allItemXpath,
                                           String expectedValueItem) throws Exception {
        javascriptExecutor = (JavascriptExecutor) driver;
        waitExplicit = new WebDriverWait(driver, 30);

        element = driver.findElement(By.xpath(parentXpath));
        javascriptExecutor.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);

        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        elements = driver.findElements(By.xpath(allItemXpath));
//        System.out.println("Tat ca phan tu trong dropdown =" + elements.size());
        for (WebElement childElement : elements) {
//            System.out.println("Child gettext: "+ childElement.getText());
            if (childElement.getText().equals(expectedValueItem)) {
                if (childElement.isDisplayed()) {
                    childElement.click();
                } else {
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    Thread.sleep(1000);
                    javascriptExecutor.executeScript("arguments[0].click();", childElement);
                }
                Thread.sleep(1000);
                break;
            }
        }
    }
    public void dsadsa() {
        String a = " dsadsa";
        String b = "dsadsa";
        if (!a.contentEquals(b)) {

        }
    }
    public void selectItemInCustomDropdownClickByWebdriver(WebDriver driver, String clickDropdown, String listItem, String expectedItem) throws Exception {

        WebElement parentDropdown = driver.findElement(By.xpath(clickDropdown));
        highlightElement(driver, clickDropdown);
        parentDropdown.click();
        Thread.sleep(1000);

        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listItem)));

        List<WebElement> allItems = driver.findElements(By.xpath(listItem));

        for (WebElement items : allItems) {
            if (items.getText().equals(expectedItem)) {

                if (items.isDisplayed()) {
                    items.click();

                } else {
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", items);
                    Thread.sleep(1000);
                    javascriptExecutor.executeScript("arguments[0].click();", items);
                }
                Thread.sleep(1000);
                break;

            }

        }

    }

    public void selectMultiItemInDropdown(WebDriver driver, String parentXpath, String allItemXpath, String itemSelected, String[] expectedValueItem) throws Exception {
        // click vao dropdown tat ca value
        WebElement parentDropdown = driver.findElement(By.xpath(parentXpath));
        parentDropdown.click();
//        javascriptExecutor.executeScript("arguments[0].click();", parentDropdown);
        // cho value load ra
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));

        List<WebElement> allItems = driver.findElements(By.xpath(allItemXpath));
        System.out.println("Tat ca phan tu trong dropdown =" + allItems.size());
        // duyet qua het tat ca cac phan tu
        for (WebElement childElement : allItems) {
            System.out.println("ChildElementt111: " + childElement.getText());

            for (String item : expectedValueItem) {
                System.out.println("item: " + item);
                if (childElement.getText().equals(item)) {
                    System.out.println("Child gettext: " + childElement.getText());
                    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
                    Thread.sleep(1500);

                    javascriptExecutor.executeScript("arguments[0].click();", childElement);
                    Thread.sleep(1500);

                    List<WebElement> it = driver.findElements(By.xpath(itemSelected));
//                    System.out.println("Item selected = " + it.size());
                    if (expectedValueItem.length == it.size()) {
                        break;
                    }

                }
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String attributeName, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attributeName);
    }

    public String getTextElement(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public String getTextElementByJS(WebDriver driver, String locator) {
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeScript("return document.documentElement.innerText;").toString();
    }

    public int countElementsNumber(WebDriver driver, String locator) {
        elements = driver.findElements(By.xpath(locator));
        return elements.size();
    }

    public void checkToTheCheckbox(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToTheCheckbox(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        element.click();
        if (element.isSelected()) {
            element.click();
        }
    }


    public boolean isControlDisplayed(WebDriver driver, String locator) {
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        List<WebElement> elements = driver.findElements(By.xpath(locator));

        if (elements.size() == 0) {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return true;
        } else {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return false;
        }
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);

        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);

        List<WebElement> elements = driver.findElements(By.xpath(locator));

        if (elements.size() == 0) {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return true;
        } else {
            overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);
            return false;
        }
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public boolean isControlSelected(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public boolean isControlEnables(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        return element.isEnabled();
    }

    public void switchToChildWindowByID(WebDriver driver, String parent) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parent)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public boolean closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        if (driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }

    public void hoverMouseToElement(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.doubleClick(element).perform();

    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        element = driver.findElement(By.xpath(locator));
        action = new Actions(driver);
        action.sendKeys(element, key).perform();
    }


    public void executeForBrowser(WebDriver driver, String javaSript) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript(javaSript);
    }

    public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
        javascriptExecutor = (JavascriptExecutor) driver;
        String textActual = (String) javascriptExecutor
                .executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
        return textActual.equals(textExpected);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public void scrollToElement(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value, String... values) {
        locator = String.format(locator, (Object[]) values);
        highlightElement(driver, locator);
        element = driver.findElement(By.xpath(locator));
//        element.clear();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//        jse.executeScript("document.getElementById(‘email').value=“abc.efg@xyz.com”);
    }


    public void scrollToBottomPage(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        element = driver.findElement(By.xpath(locator));
        javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }

    public Object navigateToUrlByJS(WebDriver driver, String url) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("window.location = '" + url + "'");
    }

    public boolean checkAnyImageLoaded(WebDriver driver, String locator) {
        element = driver.findElement(By.xpath(locator));
        javascriptExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) javascriptExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"underfinded\" && arguments[0].naturalWidth >0",
                element);
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    // HTML 5
    public String getHtml5ValidationMessage(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
    }

    // waitExplicit
    public void waitForElementPresence(WebDriver driver, String locator) {
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void waitForElementPresence(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));

    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byLocator));
    }

    public void waitForElementInListLoading(WebDriver driver, String locator) {
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));

    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);

        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);

    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        byLocator = By.xpath(locator);

        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        overrideGlobalTimeOut(driver, Constants.LONG_TIMEOUT);

    }

    public void overrideGlobalTimeOut(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public void highlightElement(WebDriver driver, String locator) {
        javascriptExecutor = (JavascriptExecutor) driver;
        element = driver.findElement(By.xpath(locator));
        String originalStyle = element.getAttribute("style");
        javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", "border:3px solid green; border-style:dashed;");
        try {
            Thread.sleep(Constants.TIME_HIGHLIGHT);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);
    }

    public int listSizeLocatorInElements(WebDriver driver, String listLocator, String... values) {
        listLocator = String.format(listLocator, (Object[]) values);
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listLocator)));
        List<WebElement> allItems = driver.findElements(By.xpath(listLocator));
        int size = allItems.size();
        return size;
    }

    public void selectFolder(WebDriver driver, String listFolder, String NameFolder) throws Exception {
        List<WebElement> allItems = driver.findElements(By.xpath(listFolder));

        for (WebElement folder : allItems) {

            if (folder.getText().contains(NameFolder)) {

                if (folder.isDisplayed()) {
                    folder.click();
                }
                Thread.sleep(1000);
                break;
            }

        }

    }

    // Sort Asc/Desc
    public boolean isDataSortedAsceding(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList);

        for (String name : arrayList) {
            System.out.println(name);
        }

        return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDesceding(WebDriver driver, String locator) {
        ArrayList<String> arrayList = new ArrayList<>();

        List<WebElement> elementList = driver.findElements(By.xpath(locator));

        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        for (String name : arrayList) {
            System.out.println(name);
        }

        return sortedList.equals(arrayList);
    }

    // Dynamic textbox
    public void inputIntoDynamicTextbox(WebDriver driver, String textboxNameID, String valueToSendKey) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, textboxNameID);
        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        sendkeyElements(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, valueToSendKey, textboxNameID);
    }

    public void inputIntoDynamicTextboxByJS(WebDriver driver, String textboxNameID, String valueToSendKey) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, textboxNameID);
        overrideGlobalTimeOut(driver, Constants.SHORT_TIMEOUT);
        sendkeyToElementByJS(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, valueToSendKey, textboxNameID);
    }

    // Dynamic textArea
    public void inputIntoDynamicTextArea(WebDriver driver, String textAreaNameID, String valueToSendKey) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTAREA, textAreaNameID);
        sendkeyElements(driver, AbstractPageUIs.DYNAMIC_TEXTAREA, valueToSendKey, textAreaNameID);
    }

    // Dynamic button
    public void clickIntoDynamicButtonWithClass(WebDriver driver, String nameClass) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_CLASS, nameClass);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_CLASS, nameClass);
    }

    public void clickIntoDynamicButtonWithID(WebDriver driver, String idButton) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_ID, idButton);
        clickToElementByJS(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_ID, idButton);
    }

    public void clickIntoDynamicButtonByJS(WebDriver driver, String nameClass) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_CLASS, nameClass);
        clickToElementByJS(driver, AbstractPageUIs.DYNAMIC_BUTTON_WITH_CLASS, nameClass);
    }

    // Dynamic error/ toast msg
    public String getDynamicValidate(WebDriver driver, String validateID) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_VALIDATE_WITH_ID, validateID);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_VALIDATE_WITH_ID, validateID);
    }

    public String getTextToastMessageDisplayed(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_TOAST_MSG);
    }

    public void clickCloseToastMsg(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.CLOSE_TOAST_MSG);
        clickToElementByJS(driver, AbstractPageUIs.CLOSE_TOAST_MSG);
    }

    // Dynamic Radiobutton
    public void selectDynamicRadioCheckboxWithID(WebDriver driver, String nameID) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
        clickToElementByJS(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_ID, nameID);
    }

    public void selectDynamicRadioCheckboxWithName(WebDriver driver, String name) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_NAME, name);
        clickToElementByJS(driver, AbstractPageUIs.DYNAMIC_RADIO_CHECKBOX_WITH_NAME, name);
    }

    public void selectDynamicCheckbox(WebDriver driver, String idCheckbox) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_CHECKBOX, idCheckbox);
        checkToTheCheckbox(driver, AbstractPageUIs.DYNAMIC_CHECKBOX, idCheckbox);
    }

    public void selectDynamicCheckboxWithLabelText(WebDriver driver, String nameCheckbox) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_CHECKBOX_WITH_LABEL, nameCheckbox);
        checkToTheCheckbox(driver, AbstractPageUIs.DYNAMIC_CHECKBOX_WITH_LABEL, nameCheckbox);
    }

    // Dropdownlist
    public void selectDynamicDropDown(WebDriver driver, String nameDropdown, String value) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN, nameDropdown);
        selectItemInDropDown(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN, value, nameDropdown);
    }

    public void selectDynamicDropDownByID(WebDriver driver, String DropdownID, String value) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN_ID, DropdownID);
        selectItemInDropDown(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN_ID, value, DropdownID);
    }

    public AbstractPage openMultiPageInFooter(WebDriver driver, String pagename) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, pagename);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_ITEM_FOOTER_PAGE, pagename);

        switch (pagename) {
            case "Search":
                return CustomerPageGeneratorManager.getSearchPage(driver);
            case "Recently viewed products":
                return CustomerPageGeneratorManager.getReviewProductPage(driver);
            case "Compare products list":
                return CustomerPageGeneratorManager.getCompareProductListPage(driver);
            case "Wishlist":
                return CustomerPageGeneratorManager.getWishListPage(driver);
            default:
                return CustomerPageGeneratorManager.getHomePage(driver);
        }
    }

    public AbstractPage openMultiPageInLeftBar(WebDriver driver, String pageName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_MENU_LEFT_BAR, pageName);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_MENU_LEFT_BAR, pageName);

        switch (pageName) {
            case "Customer info":
                return CustomerPageGeneratorManager.getCustomerInfoPage(driver);
            case "Addresses":
                return CustomerPageGeneratorManager.getAddressPage(driver);
            case "Change password":
                return CustomerPageGeneratorManager.getChangePasswordPage(driver);
            case "Orders":
                return CustomerPageGeneratorManager.getOrderPage(driver);
            default:
                return CustomerPageGeneratorManager.getMyAccountPage(driver);

        }
    }

    public AbstractPage openMultiPageInItemHeader(WebDriver driver, String classNamePage) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_ITEM_ON_HEADER, classNamePage);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_ITEM_ON_HEADER, classNamePage);

        switch (classNamePage) {
            case "ico-account":
                return CustomerPageGeneratorManager.getMyAccountPage(driver);
            case "ico-logout":
                return CustomerPageGeneratorManager.getMainPage(driver);
            case "ico-wishlist":
                return CustomerPageGeneratorManager.getWishListPage(driver);
            case "ico-cart":
                return CustomerPageGeneratorManager.getShoppingCartPage(driver);
            default:
                return null;
        }
    }

    // menu bar
    public void hoverIntoMenuTopProduct(WebDriver driver, String nameCategory) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        hoverMouseToElement(driver, AbstractPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public void clickIntoMenuTopProduct(WebDriver driver, String nameCategory) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_MENU_TOP_PRODDUCT, nameCategory);
    }

    public HomePageObject clickLogoNopCommerce(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.LOGO_NOP);
        clickToElement(driver, AbstractPageUIs.LOGO_NOP);
        return CustomerPageGeneratorManager.getHomePage(driver);
    }


    // get number product on header
    public String getNumberProduct(WebDriver driver, String classItem) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_NUMER_PRODUCT_ON_ITEM_HEADER, classItem);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_NUMER_PRODUCT_ON_ITEM_HEADER, classItem);
    }

    // hover into Shopping card header
    public void hoverIntoShoppingCartHeader(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.SHOPPING_CART_ITEM_HEADER);
        hoverMouseToElement(driver, AbstractPageUIs.SHOPPING_CART_ITEM_HEADER);
    }

    public String getNumberCountItemOnShoppingCartHeader(WebDriver driver, String number) {
        waitForElementVisible(driver, AbstractPageUIs.COUNT_PRODUCT_ADD_SHOPPING_CART_ITEM_HEADER, number);
        return getTextElement(driver, AbstractPageUIs.COUNT_PRODUCT_ADD_SHOPPING_CART_ITEM_HEADER, number);
    }

    public String getTextNameProductOnShoppingCartHeader(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.ATTRIBUTE_PRODUCT_SHOPPING_CART_ITEM_HEADER);
        return getTextElement(driver, AbstractPageUIs.ATTRIBUTE_PRODUCT_SHOPPING_CART_ITEM_HEADER);
    }

    public String getUnitPriceOnShoppingCartHeader(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.UNIT_PRICE_SHOPPING_CART_ITEM_HEADER);
        return getTextElement(driver, AbstractPageUIs.UNIT_PRICE_SHOPPING_CART_ITEM_HEADER);
    }

    public String getQuantityProductOnShoppingCartHeader(WebDriver driver) {
        waitForElementVisible(driver, AbstractPageUIs.QUANTITY_PRODUCT_SHOPPING_CART_ITEM_HEADER);
        return getTextElement(driver, AbstractPageUIs.QUANTITY_PRODUCT_SHOPPING_CART_ITEM_HEADER);
    }

    public boolean isMessageEmptyDisplayed(WebDriver driver) {
        waitForElementVisible(driver, WishListPageUIs.MESSAGE_EMPTY);
        return isControlDisplayed(driver, WishListPageUIs.MESSAGE_EMPTY);
    }

    public String getDynamicInforInConfirmOrder(WebDriver driver, String title, String classFieldInTitle) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_CONFIRM_ORDER, title, classFieldInTitle);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_CONFIRM_ORDER, title, classFieldInTitle).trim();

    }

    public String getDynamicInfoTableData(WebDriver driver, String className, String tagName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_INFOR_TABLE_DATA, className, tagName);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_INFOR_TABLE_DATA, className, tagName);
    }

    public String getDynamicInforCartFooter(WebDriver driver, String nameField) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_INFOR_CART_FOOTER, nameField);
        return getTextElement(driver, AbstractPageUIs.DYNAMIC_INFOR_CART_FOOTER, nameField);
    }


    // Admin
    public AbstractPage openMultiPageInItemSubMenuBarMini(WebDriver driver, String nameMenu) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SUB_MENUBAR_MINI, nameMenu);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_SUB_MENUBAR_MINI, nameMenu);

        switch (nameMenu) {
            case "Products":
                return AdminPageGeneratorManager.getProductsPage(driver);
            case "Customers":
                return AdminPageGeneratorManager.getCustomerPage(driver);

            default:
                return null;
        }
    }

    public void clickIntoDynamicMenuBarMini(WebDriver driver, String nameMenu) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SLIDE_MENUBAR_MINI, nameMenu);
        clickToElement(driver, AbstractPageUIs.DYNAMIC_SLIDE_MENUBAR_MINI, nameMenu);
    }

    public String getAttributeInTextbox(WebDriver driver, String idField, String nameAttribue) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, idField);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, "value", idField);
    }

    public String getAttributeInRadio(WebDriver driver, String nameField, String idRadio, String nameAttribue) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_RADIO_ADMIN);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_RADIO_ADMIN, idRadio, nameAttribue, nameField);
    }
    public String getDynamicAttribueTextboxValue(WebDriver driver, String textboxID, String attributeName) {
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, textboxID);
        return getAttributeValue(driver, AbstractPageUIs.DYNAMIC_TEXTBOX_WITH_ID, attributeName, textboxID);
    }
    public String getFirstValueSelectedInDropDown(WebDriver driver, String idDropdown){
        waitForElementVisible(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN_ID, idDropdown);
        return  getFirstSelectedDropdown(driver, AbstractPageUIs.DYNAMIC_SELECT_DROPDOWN_ID, idDropdown);
    }

    private WebElement element;
    private List<WebElement> elements;
    private Select select;
    private JavascriptExecutor javascriptExecutor;
    private WebDriverWait waitExplicit;
    private Actions action;
    private By byLocator;
    private int longTimeOut = Constants.LONG_TIMEOUT;


}