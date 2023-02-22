package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CommonPage{
    @FindBy(css = "td.align-middle.text-end svg")
    public List<WebElement> removeProductFromCart;


    @FindBy(css = "button.Basket_checkOutBtn__1946L")
    public WebElement proceedToCheckOut;

    @FindBy(css = "button.collapsible_toggle__1oudq")
    public WebElement enterPromoCode_button;

    @FindBy(css = "[placeholder='your promo code']")
    public WebElement enterPromoCode_text;

    @FindBy(id = "promo-code")
    public WebElement enterPromoCode_apply;


    @FindBy(xpath = "(//td[@class='text-end py-3'])[1]/p")
    public WebElement cartTotal_subtotal;



    @FindBy(xpath = "(//td[@class='text-end py-3'])[2]")
    public WebElement cartTotal_deliveryCost;

    @FindBy(xpath = "(//td[@class='text-end py-3'])[3]")
    public WebElement cartTotal_total;

    @FindBy(css = "button.proceed_btn__vZFGE[type='button']")
    public WebElement next;

    @FindBy(xpath = "//button[@class='proceed_btn__vZFGE'][2]")
    public WebElement goToPayment;

    @FindBy(css = ".css-ltr-1m7plzc-button-Button")
    public WebElement paypal_btnLogin_up;
    @FindBy(id = "btnLogin")
    public WebElement paypal_btnLogin_down;

}
