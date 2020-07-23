package commons;

import PageObjects.HomePageObject;
import PageObjects.MainPageObject;
import PageObjects.LoginPageObject;
import PageObjects.RegisterPageObject;
import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
    public static MainPageObject getMainPage(WebDriver driver) {
        return new MainPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);

    }
}
