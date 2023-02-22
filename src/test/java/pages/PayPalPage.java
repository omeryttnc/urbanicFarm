package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayPalPage extends CommonPage{

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;


    @FindBy(id = "btnLogin")
    public WebElement btnLogin;

    @FindBy(id = "payment-submit-btn")
    public WebElement payment_submit_btn;

    @FindBy(css = ".font-weight-bold")
    public WebElement paymentSuccesfull;

}
