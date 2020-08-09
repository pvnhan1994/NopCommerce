package commons;

import PageObjects.*;
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

    public static MyAccountPageObject getMyAccountPage(WebDriver driver){
        return new MyAccountPageObject(driver);
    }

    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
    public static AddressPageObject getAddressPage(WebDriver driver){
        return new AddressPageObject(driver);
    }
    public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }
    public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver){
        return new MyProductReviewsPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver){
        return new SearchPageObject(driver);
    }
    public static WishListPageObject getWishListPage(WebDriver driver){
        return new WishListPageObject(driver);
    }
    public static CompareProductListPageObject getCompareProductListPage(WebDriver driver){
        return new CompareProductListPageObject(driver);
    }
    public static ReviewProductPageObject getReviewProductPage(WebDriver driver){
        return new ReviewProductPageObject(driver);
    }
    public static ProductDetailPageObject getProductDetail(WebDriver driver){
        return new ProductDetailPageObject(driver);
    }
    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver){
        return new ShoppingCartPageObject(driver);
    }
}
