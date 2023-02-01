package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class RegisterPage extends CommonPage {
    @FindBy(css = "#registration_form_firstname")
    public WebElement firstName_registerForm;

    // ctrl D -> duplicate
    @FindBy(css = "#registration_form_lastname")
    public WebElement lastName_registerForm;



    // 2. yol
   public WebElement webElement = getDriver().findElement(By.cssSelector("#registration_form_firstname"));
}
