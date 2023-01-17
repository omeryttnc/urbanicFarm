package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPage {

    @FindBy(css = "//a[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "(//a[text()='Logout'])[2]")
    public WebElement logoutButton;
}
