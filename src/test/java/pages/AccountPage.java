package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends CommonPage {
    @FindBy(css = "div>a[href$='account/home']")
    public WebElement account_sideBar;

    @FindBy(css = "svg.cursor-pointer:last-of-type")
    public WebElement download;

    @FindBy(css = "svg.cursor-pointer:nth-of-type(1)")
    public WebElement copy;

    @FindBy(css = ".btn-outline-warning")
    public WebElement edit;

    @FindBy(css = "[name='phone']")
    public WebElement phone;

    @FindBy(css = ".btn-outline-primary")
    public WebElement save;

    @FindBy(css = "input.Profile_imgInput__3CXq7")
    public WebElement chooseFile;

    @FindBy(css = ".rounded-circle.bg-white")
    public WebElement userLogo;

    @FindBy(css = "div.toastr_custom-toastr__iiU37")
    public WebElement toastMessage;


    @FindBy(css = "#QRCode")
    public WebElement qrCode;
    @FindBy(css = "tr:nth-of-type(2) td.Profile_td__w9cTI:nth-of-type(2)")
    public WebElement firstName;

    @FindBy(css = "tr:nth-of-type(3) td.Profile_td__w9cTI:nth-of-type(2)")
    public WebElement email;


    @FindBy(css = "span.AccountLayout_backtoTop__1FvtX")
    public WebElement toggle;


}
