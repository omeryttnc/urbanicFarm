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
}




