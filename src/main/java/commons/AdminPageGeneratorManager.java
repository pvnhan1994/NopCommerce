package commons;

import adminPageObjects.LoginPageObject;
import adminPageObjects.ProductsPageObject;
import adminPageObjects.DashboardPageObject;

import org.openqa.selenium.WebDriver;

public class AdminPageGeneratorManager {
    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }

    public static ProductsPageObject getProductsPage(WebDriver driver){
        return new ProductsPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }
}
