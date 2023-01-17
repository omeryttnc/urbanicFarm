package pages;

import enums.USERINFO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(css = "[name='email']")
    private WebElement emailText;

    @FindBy(css = "[name='password']")
    private WebElement passwordText;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public void loginMethod(String email, String password) {
        emailText.sendKeys(email);
        passwordText.sendKeys(password);
        submitButton.click();
    }

    public void loginMethod(USERINFO user) {
        emailText.sendKeys(user.getEmail());
        passwordText.sendKeys(user.getPassword());
        submitButton.click();
    }


}
