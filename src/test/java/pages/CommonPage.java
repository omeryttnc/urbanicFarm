package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;


public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private LoginPage loginPage;
    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountPage accountPage;
    private ProductPage productPage;
    private DeliveryAndPickupSettings settings;
    private PayPalPage payPalPage;
    private CartPage cartPage;

    public PayPalPage getPayPalPage() {
        if (payPalPage == null) {
            payPalPage = new PayPalPage();
        }

        return payPalPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();

        }

        return cartPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public AccountPage getAccountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage();
        }
        return accountPage;
    }

    public RegisterPage getRegisterPage() {

        if (registerPage == null) {
            registerPage = new RegisterPage();
        }

        return registerPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public DeliveryAndPickupSettings getSettings() {
        if (settings == null) {
            settings = new DeliveryAndPickupSettings();
        }
        return settings;
    }
}




